package net.exathunk.farce.reader;

import net.exathunk.jsubschema.functional.Either;
import org.codehaus.jackson.JsonNode;

/**
 * charolastra 11/27/12 9:02 PM
 */
public class SingleLateRefResolver implements LateRefResolver {
    private final String ref;
    private final JsonNode node;

    public SingleLateRefResolver(String ref, JsonNode node) {
        this.ref = ref;
        this.node = node;
    }

    @Override
    public Either<JsonNode, String> resolveLateRef(String lateRef) {
        if (lateRef.equals(ref)) {
            return Either.makeFirst(node);
        } else {
            return Either.makeSecond("Could not resolve late ref: "+lateRef+" want "+ref);
        }
    }
}
