/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.api.rest.resources.knowledgeareas.converter;

import java.time.LocalDateTime;
import javax.ejb.Stateless;
import pt.cmg.sweranker.api.resources.knowledgeareas.dto.response.DetailedKnowledgeAreaDTO;
import pt.cmg.sweranker.persistence.entities.knowledgebodies.KnowledgeAreaTranslation;

/**
 * @author Carlos Manuel
 */
@Stateless
public class KnowledgeAreaConverter {

    public DetailedKnowledgeAreaDTO toDetailedKnowledgeAreaDTO(KnowledgeAreaTranslation knowledgeArea) {

        DetailedKnowledgeAreaDTO dto = new DetailedKnowledgeAreaDTO();

        dto.id = knowledgeArea.getId();
        dto.image = knowledgeArea.getKnowledgeArea().getImage();
        dto.name = knowledgeArea.getTranslatedName();
        dto.description = knowledgeArea.getTranslatedDescription();
        dto.now = LocalDateTime.now();

        return dto;
    }

}
