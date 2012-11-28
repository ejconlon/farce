package net.exathunk.farce.genschema.endpoint;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
    String getRequest();

    @JsonProperty("request")
    void setRequest(String request);

    boolean hasResponses();

    @JsonProperty("responses")
    List<String> getResponses();

    @JsonProperty("responses")
    void setResponses(List<String> responses);

}
