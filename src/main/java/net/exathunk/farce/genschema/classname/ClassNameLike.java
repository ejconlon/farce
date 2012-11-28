package net.exathunk.farce.genschema.classname;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = ClassName.class)
public interface ClassNameLike {

    boolean hasClassName();

    @JsonProperty("className")
    String getClassName();

    @JsonProperty("className")
    void setClassName(String className);

}
