package net.exathunk.farce.genschema.applicationkeys;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class ApplicationKeysFactory implements DomainFactory<ApplicationKeys> {

    @Override
    public Class<ApplicationKeys> getDomainClass() {
        return ApplicationKeys.class;
    }

    @Override
    public ApplicationKeys makeDomain() {
        return new ApplicationKeys();
    }

}
