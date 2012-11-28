package net.exathunk.farce.reader;

import net.exathunk.jsubschema.Util;
import net.exathunk.jsubschema.base.SchemaNode;
import net.exathunk.jsubschema.base.Session;
import net.exathunk.jsubschema.functional.Either;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import net.exathunk.jsubschema.pointers.PointedRef;
import net.exathunk.jsubschema.pointers.Reference;
import net.exathunk.jsubschema.validation.VContext;
import net.exathunk.jsubschema.validation.VError;
import net.exathunk.jsubschema.validation.Validator;
import org.codehaus.jackson.JsonNode;

/**
 * charolastra 11/27/12 3:37 PM
 */
public class LateRefValidator implements Validator {

    private final Session session;
    private final Validator subValidator;
    private final LateRefResolver lateRefResolver;

    public LateRefValidator(Session session, LateRefResolver lateRefResolver, Validator subValidator) {
        this.session = session;
        this.lateRefResolver = lateRefResolver;
        this.subValidator = subValidator;
    }

    @Override
    public void validate(SchemaNode node, VContext context) {
        // If this is a node with an $instance decl
        final SchemaLike schema = node.getEitherSchema().getFirst().getSchema();
        if (schema.has__dollar__instance()) {
            final JsonNode n = node.getPointedNode().getNode();
            // First check that this is a string and we can load the thing
            if (!n.isTextual()) {
                context.errors.add(new VError(node, "Need textual node for $instance, found "+n));
                return;
            }
            Either<JsonNode, String> instance = lateRefResolver.resolveLateRef(n.asText());
            if (instance.isSecond()) {
                context.errors.add(new VError(node, instance.getSecond()));
                return;
            }
            // Then check if we can resolve the schema in $instance
            // This should succeed if InstanceResolver passes, so no extra un-Either logic here
            SchemaLike subSchema = node.getFullRefResolver().fullyResolveRef(new PointedRef(Reference.fromReferenceString(schema.get__dollar__instance()).getFirst())).getFirst().getSchema();
            // Then check that the instance satisfies the schema
            VContext subContext = Util.runValidator(subValidator, session, subSchema, instance.getFirst());
            context.subsume("LateRefValidator: ", subContext);
        }
    }
}
