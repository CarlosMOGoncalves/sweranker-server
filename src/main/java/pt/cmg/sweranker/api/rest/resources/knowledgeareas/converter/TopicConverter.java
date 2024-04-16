/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.api.rest.resources.knowledgeareas.converter;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import pt.cmg.sweranker.api.resources.knowledgeareas.dto.response.TopicDTO;
import pt.cmg.sweranker.persistence.entities.TropicanaTranslationAgain;

/**
 * @author Carlos Gonçalves
 */
@Stateless
public class TopicConverter {

    public List<TopicDTO> toTopicDTOs(List<TropicanaTranslationAgain> translatedTopics) {
        return translatedTopics.stream().map(this::toTopicDTO).collect(Collectors.toList());
    }

    public TopicDTO toTopicDTO(TropicanaTranslationAgain translatedTopic) {

        TopicDTO dto = new TopicDTO();
        dto.id = translatedTopic.getTopic().getId();
        dto.name = translatedTopic.getName();
        dto.description = translatedTopic.getDescription();
        return dto;
    }

}
