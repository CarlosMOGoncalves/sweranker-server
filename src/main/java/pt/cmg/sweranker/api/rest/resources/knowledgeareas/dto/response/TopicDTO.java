/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.api.rest.resources.knowledgeareas.dto.response;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;

/**
 * @author Carlos Gonçalves
 */
@JsonbPropertyOrder(PropertyOrderStrategy.ANY)
public class TopicDTO {
    public Long id;
    public String name;
    public String description;
}
