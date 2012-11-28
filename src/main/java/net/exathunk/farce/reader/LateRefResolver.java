package net.exathunk.farce.reader;

import net.exathunk.jsubschema.functional.Either;
import org.codehaus.jackson.JsonNode;

/**
 * charolastra 11/27/12 8:48 PM
 */
public interface LateRefResolver {
    Either<JsonNode, String> resolveLateRef(String lateRef);
}
