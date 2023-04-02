package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "url.web-base", defaultValue = "") 
    String url;

    @ConfigProperty(name = "url-base.web-base") 
    String urlBase;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        ;
        return """
            Hello from RESTEasy Reactive: %s
            urlBase: %s
                """.formatted(url, urlBase);
    }
}