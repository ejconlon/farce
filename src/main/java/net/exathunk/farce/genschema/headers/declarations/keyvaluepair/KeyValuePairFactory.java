package net.exathunk.farce.genschema.headers.declarations.keyvaluepair;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class KeyValuePairFactory implements DomainFactory<KeyValuePair> {

    @Override
    public Class<KeyValuePair> getDomainClass() {
        return KeyValuePair.class;
    }

    @Override
    public KeyValuePair makeDomain() {
        return new KeyValuePair();
    }

}
