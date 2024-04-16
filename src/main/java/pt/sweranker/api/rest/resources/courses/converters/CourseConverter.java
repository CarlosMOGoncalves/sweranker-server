/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.sweranker.api.rest.resources.courses.converters;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import pt.sweranker.api.rest.filters.request.RequestContextData;
import pt.sweranker.api.rest.filters.request.RequestData;
import pt.sweranker.api.rest.resources.courses.dto.request.CourseSearchFilter;
import pt.sweranker.api.rest.resources.courses.dto.response.CourseDTO;
import pt.sweranker.dao.degrees.DegreeDAO.DegreeFilterCriteria;
import pt.sweranker.persistence.entities.degrees.Course;

/**
 * @author Carlos Gonçalves
 */
@Stateless
public class CourseConverter {

    @Inject
    @RequestData
    private RequestContextData requestData;

    public DegreeFilterCriteria toDegreeFilterCriteria(CourseSearchFilter searchFilter) {
        return new DegreeFilterCriteria(searchFilter.university, requestData.getSelectedLanguage(), searchFilter.year, searchFilter.name);
    }

    public List<CourseDTO> toCourseDTOs(List<Course> degrees) {
        return degrees.stream().map(this::toCourseDTO).collect(Collectors.toList());
    }

    public CourseDTO toCourseDTO(Course degree) {
        CourseDTO dto = new CourseDTO();
        dto.id = degree.getId();
        dto.acronym = degree.getAcronym();
        dto.name = degree.getName();
        dto.description = degree.getDescription();
        dto.image = degree.getImage();
        dto.university = degree.getSchool();
        dto.year = degree.getYear();

        return dto;
    }

}
