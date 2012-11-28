package net.exathunk.farce.genschema.location;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Location.class)
public interface LocationLike {

    boolean hasLocation();

    @JsonProperty("location")
    String getLocation();

    @JsonProperty("location")
    void setLocation(String location);

}
