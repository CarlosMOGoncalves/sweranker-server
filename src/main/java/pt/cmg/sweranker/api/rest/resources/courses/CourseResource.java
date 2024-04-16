/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.api.rest.resources.courses;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pt.cmg.sweranker.api.rest.filters.request.RequestContextData;
import pt.cmg.sweranker.api.rest.filters.request.RequestData;
import pt.cmg.sweranker.api.rest.resources.courses.converters.CourseConverter;
import pt.cmg.sweranker.api.rest.resources.courses.dto.request.CourseSearchFilter;
import pt.cmg.sweranker.dao.courses.CourseDAO;
import pt.cmg.sweranker.persistence.entities.degrees.Course;
import pt.cmg.sweranker.persistence.entities.degrees.DegreeTranslation;

/**
 * @author Carlos Gonçalves
 */
@Path("courses")
@Stateless
public class CourseResource {

    @Inject
    @RequestData
    private RequestContextData requestData;

    @EJB
    private CourseDAO courseDAO;

    @EJB
    private CourseConverter degreeConverter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Valid @BeanParam CourseSearchFilter filter) {
        List<Course> degrees = courseDAO.findFiltered(degreeConverter.toDegreeFilterCriteria(filter));
        return Response.ok(degreeConverter.toDegreeDTOs(degrees)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDegree(@PathParam("id") Long id) {

        DegreeTranslation degree = courseDAO.findById(id);

        return Response.ok(degreeConverter.toDegreeDTO(degree)).build();
    }
}
