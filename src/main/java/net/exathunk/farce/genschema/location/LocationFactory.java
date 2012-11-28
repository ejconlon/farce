package net.exathunk.farce.genschema.location;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class LocationFactory implements DomainFactory<Location> {

    @Override
    public Class<Location> getDomainClass() {
        return Location.class;
    }

    @Override
    public Location makeDomain() {
        return new Location();
    }

}
