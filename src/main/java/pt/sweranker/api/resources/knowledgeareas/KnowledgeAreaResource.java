package pt.sweranker.api.resources.knowledgeareas;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import pt.sweranker.api.filters.request.RequestContextData;
import pt.sweranker.api.filters.request.RequestData;
import pt.sweranker.api.resources.knowledgeareas.converter.KnowledgeAreaConverter;
import pt.sweranker.api.resources.knowledgeareas.converter.TopicConverter;
import pt.sweranker.dao.knowledgeareas.KnowledgeAreaDAO;
import pt.sweranker.dao.knowledgeareas.TopicDAO;
import pt.sweranker.persistence.entities.knowledgeareas.KnowledgeAreaTranslation;

@Path("knowledgreareas")
@Stateless
public class KnowledgeAreaResource {

    @EJB
    private KnowledgeAreaDAO knowledgeAreaDAO;

    @EJB
    private KnowledgeAreaConverter knowledgeAreaConverter;

    @EJB
    private TopicDAO topicDAO;

    @EJB
    private TopicConverter topicConverter;

    @Inject
    @RequestData
    private RequestContextData requestData;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKnowledgeArea(@PathParam("id") Long id) {

        KnowledgeAreaTranslation ka = knowledgeAreaDAO.findById(id, requestData.getSelectedLanguage());

        return Response.ok(knowledgeAreaConverter.toDetailedKnowledgeAreaDTO(ka)).build();
    }

    @GET
    @Path("{id}/topics")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTopicsOfKnowledgeArea(@PathParam("id") Long knowledgeAreaId) {

        var knowledgeArea = knowledgeAreaDAO.findById(knowledgeAreaId);

        if (knowledgeArea == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }

        var topics = topicDAO.findTopicsOfKnowledgeArea(knowledgeArea.getKnowledgeArea(), requestData.getSelectedLanguage());

        return Response.ok(topicConverter.toTopicDTOs(topics)).build();
    }

}
