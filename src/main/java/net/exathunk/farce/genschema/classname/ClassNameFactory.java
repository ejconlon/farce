package net.exathunk.farce.genschema.classname;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class ClassNameFactory implements DomainFactory<ClassName> {

    @Override
    public Class<ClassName> getDomainClass() {
        return ClassName.class;
    }

    @Override
    public ClassName makeDomain() {
        return new ClassName();
    }

}
