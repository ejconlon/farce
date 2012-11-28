package net.exathunk.farce.genschema.match;

import java.io.Serializable;
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

    boolean hasTemplateString();

    @JsonProperty("templateString")
    String getTemplateString();

    @JsonProperty("templateString")
    void setTemplateString(String templateString);

}
