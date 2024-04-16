/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.sweranker.api.rest.resources.courses.dto.request;

import javax.ws.rs.QueryParam;

/**
 * @author Carlos Gonçalves
 */
public class CourseSearchFilter {

    @QueryParam("school")
    public Long school;

    @QueryParam("year")
    public Integer year;

    @QueryParam("name")
    public String name;

    @QueryParam("acronym")
    public String acronym;

}
