package net.exathunk.farce.genschema.response;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class ResponseFactory implements DomainFactory<Response> {

    @Override
    public Class<Response> getDomainClass() {
        return Response.class;
    }

    @Override
    public Response makeDomain() {
        return new Response();
    }

}
