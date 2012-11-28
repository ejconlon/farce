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

    boolean hasSchema();

    @JsonProperty("schema")
    String getSchema();

    @JsonProperty("schema")
    void setSchema(String schema);

    boolean hasSubstitutions();

    @JsonProperty("substitutions")
    Map<String, String> getSubstitutions();

    @JsonProperty("substitutions")
    void setSubstitutions(Map<String, String> substitutions);

    boolean hasTemplateString();

    @JsonProperty("templateString")
    String getTemplateString();

    @JsonProperty("templateString")
    void setTemplateString(String templateString);

}
