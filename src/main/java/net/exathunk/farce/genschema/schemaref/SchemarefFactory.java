package net.exathunk.farce.genschema.schemaref;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class SchemarefFactory implements DomainFactory<Schemaref> {

    @Override
    public Class<Schemaref> getDomainClass() {
        return Schemaref.class;
    }

    @Override
    public Schemaref makeDomain() {
        return new Schemaref();
    }

}
