/*
 * Copyright (c) 2024 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.api.rest.resources.knowledgebodies.converter;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pt.cmg.sweranker.api.rest.resources.knowledgebodies.dto.response.KnowledgeBodyDTO;
import pt.cmg.sweranker.cache.HazelcastCache;
import pt.cmg.sweranker.persistence.entities.knowledgebodies.KnowledgeBody;

/**
 * @author Carlos Gonçalves
 */
@RequestScoped
public class KnowledgeBodyConverter {

    @Inject
    private HazelcastCache translationCache;

    public List<KnowledgeBodyDTO> toKnowledgeBodyDTOs(List<KnowledgeBody> knowledgeBodies) {
        return knowledgeBodies.stream().map(this::toKnowledgeBodyDTO).collect(Collectors.toList());
    }

    public KnowledgeBodyDTO toKnowledgeBodyDTO(KnowledgeBody knowledgeBody) {
        KnowledgeBodyDTO dto = new KnowledgeBodyDTO();
        dto.id = knowledgeBody.getId();
        dto.year = knowledgeBody.getYear();
        dto.image = knowledgeBody.getImage();
        dto.name = translationCache.getTranslatedText(knowledgeBody.getNameTextContentId());
        dto.description = translationCache.getTranslatedText(knowledgeBody.getDescriptionContentId());
        return dto;
    }

}
