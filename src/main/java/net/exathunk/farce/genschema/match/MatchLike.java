package net.exathunk.farce.genschema.match;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Match.class)
public interface MatchLike {

    boolean hasPath();

    @JsonProperty("path")
    String getPath();

    @JsonProperty("path")
    void setPath(String path);

    boolean hasSchema();

    @JsonProperty("schema")
    SchemaLike getSchema();

    @JsonProperty("schema")
    @JsonDeserialize(as = Schema.class)
    void setSchema(SchemaLike schema);

    boolean hasSubstitutions();

    @JsonProperty("substitutions")
    Map<String, String> getSubstitutions();

    @JsonProperty("substitutions")
    void setSubstitutions(Map<String, String> substitutions);

}
