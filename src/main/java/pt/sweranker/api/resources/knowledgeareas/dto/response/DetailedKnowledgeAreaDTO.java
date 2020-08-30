/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.sweranker.api.resources.knowledgeareas.dto.response;

import java.time.LocalDateTime;

/**
 * @author Carlos Gonçalves
 */
public class DetailedKnowledgeAreaDTO {

    public Long id;
    public String image;
    public String name;
    public String description;
    public LocalDateTime now;
}
