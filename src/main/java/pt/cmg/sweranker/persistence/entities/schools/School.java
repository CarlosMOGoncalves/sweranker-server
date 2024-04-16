/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.persistence.entities.schools;

import java.util.Objects;
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
import pt.cmg.sweranker.persistence.entities.localisation.Country;
import pt.cmg.sweranker.persistence.entities.localisation.TextContent;

/**
 * @author Carlos Gonçalves
 */
@Entity
@Table(name = "schools")
public class School {

    @Id
    @SequenceGenerator(
        sequenceName = "school_id_seq",
        allocationSize = 1,
        initialValue = 1,
        name = "SCHOOLS_SEQUENCE")
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SCHOOLS_SEQUENCE")
    private Long id;

    @Column
    private Country country;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "id")
    private TextContent nameContent;

    @Transient
    private String name;

    public School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TextContent getNameContent() {
        return nameContent;
    }

    public void setNameContent(TextContent nameContent) {
        this.nameContent = nameContent;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        School other = (School) obj;
        return Objects.equals(country, other.country) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "School [id=" + id + ", name=" + name + ", country=" + country + "]";
    }

}
