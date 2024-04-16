/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.persistence.entities.degrees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import pt.cmg.sweranker.persistence.entities.localisation.TextContent;

/**
 * @author Carlos Gonçalves
 */
@Entity
@Table(name = "courseclasstopics")
public class CourseClassTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_CLASS_TOPICS_SEQUENCE")
    @SequenceGenerator(name = "COURSE_CLASS_TOPICS_SEQUENCE",
        sequenceName = "courseclasses_id_seq",
        initialValue = 1,
        allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "order", nullable = false)
    private int order;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "description", referencedColumnName = "id")
    private TextContent descriptionContent;

    @Transient
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseclass", referencedColumnName = "id")
    private CourseClass courseClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public TextContent getDescriptionContent() {
        return descriptionContent;
    }

    public void setDescriptionContent(TextContent descriptionContent) {
        this.descriptionContent = descriptionContent;
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

    public String getDescription() {
        return description;
    }

}
