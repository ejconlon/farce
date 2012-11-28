package net.exathunk.farce.reader;

import net.exathunk.jsubschema.base.FullRefResolver;
import net.exathunk.jsubschema.base.SchemaNode;
import net.exathunk.jsubschema.base.SchemaRef;
import net.exathunk.jsubschema.functional.Either;
import net.exathunk.jsubschema.pointers.PointedRef;
import net.exathunk.jsubschema.pointers.Reference;
import net.exathunk.jsubschema.validation.VContext;
import net.exathunk.jsubschema.validation.VError;
import net.exathunk.jsubschema.validation.Validator;
import org.codehaus.jackson.JsonNode;

/**
 * charolastra 11/27/12 3:37 PM
 */
public class RefValidator implements Validator {
    @Override
    public void validate(SchemaNode node, VContext context) {
        if (node.getPointedNode().getNode().has("$ref")) {
            JsonNode refNode = node.getPointedNode().getNode().get("$ref");
            if (!refNode.isTextual()) {
                context.errors.add(new VError(node, "Expected $ref text"));
                return;
            }
            FullRefResolver fullRefResolver = node.getFullRefResolver();
            Either<Reference, String> eitherRef = Reference.fromReferenceString(refNode.asText());
            if (eitherRef.isSecond()) {
                context.errors.add(new VError(node, "Invalid $ref format: "+eitherRef.getSecond()));
                return;
            }
            PointedRef pointedRef = new PointedRef(eitherRef.getFirst());
            Either<SchemaRef, String> resolved = fullRefResolver.fullyResolveRef(pointedRef);
            if (resolved.isSecond()) {
                context.errors.add(new VError(node, "Invalid $ref: "+resolved.getSecond()));
                return;
            }
        }
    }
}
