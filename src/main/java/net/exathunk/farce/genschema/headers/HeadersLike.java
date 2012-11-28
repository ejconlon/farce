package net.exathunk.farce.genschema.headers;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Headers.class)
public interface HeadersLike extends Map<String, MatchLike> {

}
