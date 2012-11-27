package net.exathunk.farce.genschema.headers;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class HeadersFactory implements DomainFactory<Headers> {

    @Override
    public Class<Headers> getDomainClass() {
        return Headers.class;
    }

    @Override
    public Headers makeDomain() {
        return new Headers();
    }

}
