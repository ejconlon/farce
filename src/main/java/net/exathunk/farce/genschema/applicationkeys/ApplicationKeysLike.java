package net.exathunk.farce.genschema.applicationkeys;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = ApplicationKeys.class)
public interface ApplicationKeysLike {

    boolean hasApplicationId();

    @JsonProperty("applicationId")
    String getApplicationId();

    @JsonProperty("applicationId")
    void setApplicationId(String applicationId);

    boolean hasRestApiKey();

    @JsonProperty("restApiKey")
    String getRestApiKey();

    @JsonProperty("restApiKey")
    void setRestApiKey(String restApiKey);

}
