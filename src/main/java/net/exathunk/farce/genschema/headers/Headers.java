package net.exathunk.farce.genschema.headers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.exathunk.farce.genschema.headers.declarations.keyvaluepair.KeyValuePair;
import net.exathunk.farce.genschema.headers.declarations.keyvaluepair.KeyValuePairLike;

public class Headers extends ArrayList<KeyValuePairLike> implements Cloneable, Serializable, HeadersLike {

}
