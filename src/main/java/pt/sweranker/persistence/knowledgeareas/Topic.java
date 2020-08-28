/**
 * Copyright (c) 2020  Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.sweranker.persistence.knowledgeareas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Carlos Gonçalves
 */
@Entity(name = "topics")
public class Topic implements Serializable {

    /**
     * Auto-generated by IDE
     */
    private static final long serialVersionUID = 6025578077962121721L;

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "knowledgeareaid", referencedColumnName = "id")
    private KnowledgeArea knowledgeArea;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic", fetch = FetchType.LAZY)
    private List<TopicTranslation> translations;

    public Long getId() {
        return id;
    }

    public List<TopicTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TopicTranslation> translations) {
        this.translations = translations;
    }

}
