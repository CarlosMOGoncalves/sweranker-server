package pt.cmg.sweranker.dao.knowledgeareas;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import pt.cmg.sweranker.dao.JPACrudDAO;
import pt.cmg.sweranker.persistence.entities.Language;
import pt.cmg.sweranker.persistence.entities.knowledgebodies.KnowledgeArea;

@Stateless
public class KnowledgeAreaDAO extends JPACrudDAO<KnowledgeArea> {

    public KnowledgeAreaDAO() {
        super(KnowledgeArea.class);
    }

    /**
     * Fetches a KnowledgeAreaTranslation by its id in the default language, returning a default if it didn't find any result of the
     * required language
     *
     * @param id
     * @return
     */
    @Override
    public KnowledgeArea findById(Long id) {

        TypedQuery<KnowledgeArea> query = getEntityManager().createNamedQuery("KnowledgeAreaTranslation.findByIdAndLanguage", KnowledgeArea.class);
        query.setParameter("id", id);
        query.setParameter("language", Language.DEFAULT_LANGUAGE);

        return query.getResultList().get(0);
    }

    /**
     * Fetches a KnowledgeAreaTranslation by its id and for a given language, returning a default if it didn't find any result of the
     * required language
     *
     * @param id
     * @param language
     * @return
     */
    public KnowledgeArea findById(Long id, Language language) {

        if (language == null) {
            language = Language.DEFAULT_LANGUAGE;
        }

        TypedQuery<KnowledgeArea> query = getEntityManager().createNamedQuery("KnowledgeAreaTranslation.findByIdAndLanguage", KnowledgeArea.class);
        query.setParameter("id", id);
        query.setParameter("language", language);

        return query.getResultList().get(0);
    }

}
