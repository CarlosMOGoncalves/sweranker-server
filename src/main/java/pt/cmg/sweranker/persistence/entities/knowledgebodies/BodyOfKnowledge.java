/*
 * Copyright (c) 2024 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.persistence.entities.knowledgebodies;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import pt.cmg.sweranker.persistence.entities.localisation.TextContent;

/**
 * @author Carlos Gonçalves
 */
@Entity
@Table(name = "bodiesofknowledge")
public class BodyOfKnowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOK_SEQUENCE")
    @SequenceGenerator(name = "BOK_SEQUENCE",
        sequenceName = "bodiesofknowledge_id_seq",
        initialValue = 1,
        allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "image", nullable = true)
    private String image;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "id")
    private TextContent nameContent;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "description", referencedColumnName = "id")
    private TextContent descriptionContent;

    @Transient
    private String name;

    @Transient
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TextContent getNameContent() {
        return nameContent;
    }

    public void setNameContent(TextContent nameContent) {
        this.nameContent = nameContent;
    }

    public TextContent getDescriptionContent() {
        return descriptionContent;
    }

    public void setDescriptionContent(TextContent descriptionContent) {
        this.descriptionContent = descriptionContent;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
