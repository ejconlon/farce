package net.exathunk.farce.genschema.request;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class RequestFactory implements DomainFactory<Request> {

    @Override
    public Class<Request> getDomainClass() {
        return Request.class;
    }

    @Override
    public Request makeDomain() {
        return new Request();
    }

}
