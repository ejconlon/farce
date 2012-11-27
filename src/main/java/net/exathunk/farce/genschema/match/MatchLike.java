package net.exathunk.farce.genschema.match;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.schemaref.Schemaref;
import net.exathunk.farce.genschema.schemaref.SchemarefLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Match.class)
public interface MatchLike {

    boolean hasPath();

    @JsonProperty("path")
    String getPath();

    @JsonProperty("path")
    void setPath(String path);

    boolean hasSchemaref();

    @JsonProperty("schemaref")
    SchemarefLike getSchemaref();

    @JsonProperty("schemaref")
    @JsonDeserialize(as = Schemaref.class)
    void setSchemaref(SchemarefLike schemaref);

    boolean hasSubstitutions();

    @JsonProperty("substitutions")
    Map<String, String> getSubstitutions();

    @JsonProperty("substitutions")
    void setSubstitutions(Map<String, String> substitutions);

}
