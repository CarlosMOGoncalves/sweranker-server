/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.dao.courses;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import pt.cmg.sweranker.dao.JPACrudDAO;
import pt.cmg.sweranker.persistence.entities.degrees.Course;
import pt.cmg.sweranker.persistence.entities.schools.School;

/**
 * @author Carlos Gonçalves
 */
@Stateless
public class CourseDAO extends JPACrudDAO<Course> {

    private static final String BASE_SELECT_SCHOOL_QUERY = "SELECT c FROM Course c ";

    public static final String AND = " AND ";

    public CourseDAO() {
        super(Course.class);
    }

    public List<Course> findFiltered(CourseFilterCriteria filterParameters) {

        StringBuilder selectText = new StringBuilder(BASE_SELECT_SCHOOL_QUERY);
        StringBuilder filterText = new StringBuilder();
        String prefix = " WHERE ";

        if (filterParameters.acronym != null) {
            filterText.append(prefix).append("c.acronym = :acronym ");
            prefix = AND;
        }

        if (filterParameters.school != null) {
            filterText.append(prefix).append("c.school = :school ");
            prefix = AND;
        }

        if (filterParameters.year != null) {
            filterText.append(prefix).append("c.year = :year ");
            prefix = AND;
        }

        if (filterParameters.name != null) {
            filterText.append(prefix).append("c.name = :name ");
        }

        String queryText = selectText.append(filterText).toString();
        TypedQuery<Course> query = getEntityManager().createQuery(queryText, Course.class);

        setDegreeQueryParameters(query, filterParameters);

        return query.getResultList();
    }

    private void setDegreeQueryParameters(TypedQuery<Course> query, CourseFilterCriteria filterParameters) {

        if (filterParameters.acronym != null) {
            query.setParameter("school", filterParameters.acronym);
        }

        if (filterParameters.school != null) {
            query.setParameter("school", filterParameters.school);
        }

        if (filterParameters.year != null) {
            query.setParameter("year", filterParameters.year);
        }

        if (filterParameters.name != null) {
            query.setParameter("name", filterParameters.name);
        }
    }

    public static class CourseFilterCriteria {

        public CourseFilterCriteria(School school, Integer year, String name, String acronym) {
            super();
            this.school = school;
            this.year = year;
            this.name = name;
            this.acronym = acronym;
        }

        public School school;
        public Integer year;
        public String name;
        public String acronym;
    }
}
