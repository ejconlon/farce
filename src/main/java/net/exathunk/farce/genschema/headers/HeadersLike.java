package net.exathunk.farce.genschema.headers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.exathunk.farce.genschema.headers.declarations.keyvaluepair.KeyValuePair;
import net.exathunk.farce.genschema.headers.declarations.keyvaluepair.KeyValuePairLike;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = Headers.class)
public interface HeadersLike extends List<KeyValuePairLike> {

}
