/**
 * Copyright (c) 2024 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.persistence.entities.localisation;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import pt.cmg.sweranker.persistence.entities.Language;

@Entity
@Table(name = "textcontents")
public class TextContent {

    @Id
    @SequenceGenerator(
        sequenceName = "textcontents_id_seq",
        allocationSize = 1,
        initialValue = 1,
        name = "TEXTCONTENTS_SEQUENCE")
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "TEXTCONTENTS_SEQUENCE")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column
    private String textValue;

    public TextContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, textValue);
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
        TextContent other = (TextContent) obj;
        return Objects.equals(id, other.id) && language == other.language && Objects.equals(textValue, other.textValue);
    }

}
