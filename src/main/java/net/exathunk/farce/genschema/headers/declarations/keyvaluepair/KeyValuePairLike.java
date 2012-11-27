package net.exathunk.farce.genschema.headers.declarations.keyvaluepair;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = KeyValuePair.class)
public interface KeyValuePairLike {

    boolean hasKey();

    @JsonProperty("key")
    String getKey();

    @JsonProperty("key")
    void setKey(String key);

    boolean hasValue();

    @JsonProperty("value")
    MatchLike getValue();

    @JsonProperty("value")
    @JsonDeserialize(as = Match.class)
    void setValue(MatchLike value);

}
