package net.exathunk.farce.genschema.endpoint;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class EndpointFactory implements DomainFactory<Endpoint> {

    @Override
    public Class<Endpoint> getDomainClass() {
        return Endpoint.class;
    }

    @Override
    public Endpoint makeDomain() {
        return new Endpoint();
    }

}
