/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.sweranker.persistence.knowledgeareas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import org.eclipse.persistence.config.QueryHints;
import pt.sweranker.persistence.Language;

/**
 * @author Carlos Gonçalves
 */
@Entity(name = "TopicTranslations")
@NamedQuery(
    name = "TopicTranslations.findByIdAndLanguage",
    query = "SELECT tp FROM TopicTranslations tp INNER JOIN FETCH tp.topic t WHERE t.id = :id AND tp.language = :language",
    hints = {
        @QueryHint(name = QueryHints.QUERY_RESULTS_CACHE_TYPE, value = "FULL")

    })
public class TopicTranslation {

    @Id
    @ManyToOne
    @JoinColumn(name = "topicId", referencedColumnName = "id")
    private Topic topic;

    @Column(name = "language", nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
