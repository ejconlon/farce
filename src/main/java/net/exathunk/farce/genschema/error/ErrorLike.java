package net.exathunk.farce.genschema.error;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Error.class)
public interface ErrorLike {

    boolean hasData();

    @JsonProperty("data")
    MatchLike getData();

    @JsonProperty("data")
    @JsonDeserialize(as = Match.class)
    void setData(MatchLike data);

    boolean hasMessage();

    @JsonProperty("message")
    String getMessage();

    @JsonProperty("message")
    void setMessage(String message);

}
