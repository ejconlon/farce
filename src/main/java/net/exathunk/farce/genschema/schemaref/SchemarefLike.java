package net.exathunk.farce.genschema.schemaref;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.schema.Schema;
import net.exathunk.farce.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Schemaref.class)
public interface SchemarefLike {

    boolean hasRef();

    @JsonProperty("ref")
    String getRef();

    @JsonProperty("ref")
    void setRef(String ref);

    boolean hasSchema();

    @JsonProperty("schema")
    SchemaLike getSchema();

    @JsonProperty("schema")
    @JsonDeserialize(as = Schema.class)
    void setSchema(SchemaLike schema);

}
