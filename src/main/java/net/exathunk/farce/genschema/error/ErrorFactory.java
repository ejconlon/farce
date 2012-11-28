package net.exathunk.farce.genschema.error;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class ErrorFactory implements DomainFactory<Error> {

    @Override
    public Class<Error> getDomainClass() {
        return Error.class;
    }

    @Override
    public Error makeDomain() {
        return new Error();
    }

}
