/*
 * Copyright (c) 2019 Fashion Concierge
 * All rights reserved.
 */
package pt.cmg.sweranker.dao.cache;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author Carlos Manuel
 */
@Singleton
@Startup
public class CacheLoader {

    @PersistenceUnit(unitName = "sweranker-data")
    private EntityManagerFactory entitiyManagerFactory;

    // @PostConstruct
    // public void loadCache() {
    //
    // EntityManager database = entitiyManagerFactory.createEntityManager();
    //
    // TypedQuery<KnowledgeArea> query = database.createNamedQuery("KnowledgeArea.findAll", KnowledgeArea.class);
    // var knowledgeAreas = query.getResultList();
    //
    // for (KnowledgeArea ka : knowledgeAreas) {
    //
    // TypedQuery<KnowledgeArea> kaquery = database.createNamedQuery("KnowledgeAreaTranslation.findByIdAndLanguage", KnowledgeArea.class);
    // kaquery.setParameter("id", ka.getId());
    // kaquery.setParameter("language", Language.PT_PT);
    //
    // kaquery.getResultList();
    // }
    //
    // database.close();
    //
    // }

}
