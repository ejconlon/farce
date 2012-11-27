package net.exathunk.farce.genschema.request;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.headers.Headers;
import net.exathunk.farce.genschema.headers.HeadersLike;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.farce.genschema.schemaref.Schemaref;
import net.exathunk.farce.genschema.schemaref.SchemarefLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Request.class)
public interface RequestLike {

    boolean hasHeaders();

    @JsonProperty("headers")
    HeadersLike getHeaders();

    @JsonProperty("headers")
    @JsonDeserialize(as = Headers.class)
    void setHeaders(HeadersLike headers);

    boolean hasMatch();

    @JsonProperty("match")
    MatchLike getMatch();

    @JsonProperty("match")
    @JsonDeserialize(as = Match.class)
    void setMatch(MatchLike match);

    boolean hasMethod();

    @JsonProperty("method")
    String getMethod();

    @JsonProperty("method")
    void setMethod(String method);

    boolean hasSchemaref();

    @JsonProperty("schemaref")
    SchemarefLike getSchemaref();

    @JsonProperty("schemaref")
    @JsonDeserialize(as = Schemaref.class)
    void setSchemaref(SchemarefLike schemaref);

}
