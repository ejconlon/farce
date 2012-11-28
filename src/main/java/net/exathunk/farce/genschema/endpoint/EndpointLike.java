package net.exathunk.farce.genschema.endpoint;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.request.Request;
import net.exathunk.farce.genschema.request.RequestLike;
import net.exathunk.farce.genschema.response.Response;
import net.exathunk.farce.genschema.response.ResponseLike;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Endpoint.class)
public interface EndpointLike {

    boolean hasDescription();

    @JsonProperty("description")
    String getDescription();

    @JsonProperty("description")
    void setDescription(String description);

    boolean hasRequest();

    @JsonProperty("request")
    RequestLike getRequest();

    @JsonProperty("request")
    @JsonDeserialize(as = Request.class)
    void setRequest(RequestLike request);

    boolean hasResponses();

    @JsonProperty("responses")
    List<ResponseLike> getResponses();

    @JsonProperty("responses")
    @JsonDeserialize(contentAs = Response.class)
    void setResponses(List<ResponseLike> responses);

}
