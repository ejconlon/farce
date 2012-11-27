package net.exathunk.farce.genschema.response;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.headers.Headers;
import net.exathunk.farce.genschema.headers.HeadersLike;
import net.exathunk.farce.genschema.schema.Schema;
import net.exathunk.farce.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Response.class)
public interface ResponseLike {

    boolean hasCode();

    @JsonProperty("code")
    Long getCode();

    @JsonProperty("code")
    void setCode(Long code);

    boolean hasHeaders();

    @JsonProperty("headers")
    HeadersLike getHeaders();

    @JsonProperty("headers")
    @JsonDeserialize(as = Headers.class)
    void setHeaders(HeadersLike headers);

    boolean hasSchema();

    @JsonProperty("schema")
    SchemaLike getSchema();

    @JsonProperty("schema")
    @JsonDeserialize(as = Schema.class)
    void setSchema(SchemaLike schema);

}
