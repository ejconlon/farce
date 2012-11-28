package net.exathunk.farce.reader;

import net.exathunk.jsubschema.functional.Either;
import org.codehaus.jackson.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 11/27/12 9:04 PM
 */
public class MultiLateRefResolver implements LateRefResolver {

    private final List<LateRefResolver> resolvers;

    public MultiLateRefResolver(List<LateRefResolver> resolvers) {
        this.resolvers = resolvers;
    }

    @Override
    public Either<JsonNode, String> resolveLateRef(String lateRef) {
        List<String> reasons = new ArrayList<String>();
        for (LateRefResolver resolver : resolvers) {
            Either<JsonNode, String> one = resolver.resolveLateRef(lateRef);
            if (one.isFirst()) return one;
            else reasons.add(one.getSecond());
        }
        return Either.makeSecond("Failed to resolve lateRef: "+join(reasons));
    }

    private String join(List<String> reasons) {
        String s = "";
        for (String x : reasons) { s += x + ", "; }
        return s;
    }
}
