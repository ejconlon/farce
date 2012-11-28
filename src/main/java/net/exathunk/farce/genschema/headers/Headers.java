package net.exathunk.farce.genschema.headers;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;

public class Headers extends TreeMap<String, MatchLike> implements Cloneable, Serializable, HeadersLike {

}
