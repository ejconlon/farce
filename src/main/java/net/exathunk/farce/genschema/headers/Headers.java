package net.exathunk.farce.genschema.headers;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;

public class Headers extends TreeMap<String, MatchLike> implements Cloneable, Serializable, HeadersLike {

}
