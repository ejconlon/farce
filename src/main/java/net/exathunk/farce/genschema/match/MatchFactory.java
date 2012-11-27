package net.exathunk.farce.genschema.match;

import net.exathunk.jsubschema.gendeps.DomainFactory;

public class MatchFactory implements DomainFactory<Match> {

    @Override
    public Class<Match> getDomainClass() {
        return Match.class;
    }

    @Override
    public Match makeDomain() {
        return new Match();
    }

}
