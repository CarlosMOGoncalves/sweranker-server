/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.sweranker.api.rest.filters.request;

import java.io.IOException;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import pt.cmg.sweranker.api.rest.SwerankerApplication;
import pt.cmg.sweranker.persistence.entities.Language;

/**
 * This is a global filter that checks every HTTP request for a language and if it is not sent
 * then it sets it to the default.
 *
 * @author Carlos Gonçalves
 */
public class LanguageSetterRequestFilter implements ContainerRequestFilter {

    @Inject
    @RequestData
    private Event<Language> languageEventHandler;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String requestLanguage = requestContext.getHeaders().getFirst(SwerankerApplication.REQUEST_HEADER_LANGUAGE);

        Language selectedLanguage = Language.fromString(requestLanguage);

        requestContext.getHeaders().add(SwerankerApplication.REQUEST_HEADER_LANGUAGE, selectedLanguage.toString());

        languageEventHandler.fire(selectedLanguage);
    }

}
