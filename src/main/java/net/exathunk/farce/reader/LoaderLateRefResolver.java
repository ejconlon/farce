package net.exathunk.farce.reader;

import net.exathunk.jsubschema.functional.Either;
import net.exathunk.jsubschema.gen.Loader;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;

/**
 * charolastra 11/27/12 8:49 PM
 */
public class LoaderLateRefResolver implements LateRefResolver {

    private final String prefix;

    public LoaderLateRefResolver(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Either<JsonNode, String> resolveLateRef(String lateRef) {
        if (lateRef.startsWith(prefix)) {
            String subRef = lateRef.substring(prefix.length());
            try {
                return Either.makeFirst(Loader.loadNode(subRef));
            } catch (IOException e) {
                return Either.makeSecond("Could not resolve (in prefix): "+e.getMessage());
            }
        }
        return Either.makeSecond("Could not resolve (out of prefix): "+lateRef+", want "+prefix);
    }
}
