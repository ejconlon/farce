package net.exathunk.farce.genschema.request;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.headers.Headers;
import net.exathunk.farce.genschema.headers.HeadersLike;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
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

    boolean hasSchema();

    @JsonProperty("schema")
    SchemaLike getSchema();

    @JsonProperty("schema")
    @JsonDeserialize(as = Schema.class)
    void setSchema(SchemaLike schema);

}
