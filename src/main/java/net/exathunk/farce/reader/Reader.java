package net.exathunk.farce.reader;

import net.exathunk.jsubschema.Util;
import net.exathunk.jsubschema.base.Session;
import net.exathunk.jsubschema.base.TypeException;
import net.exathunk.jsubschema.gen.Loader;
import net.exathunk.jsubschema.genschema.schema.SchemaFactory;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import net.exathunk.jsubschema.validation.InstanceValidator;
import net.exathunk.jsubschema.validation.VContext;
import net.exathunk.jsubschema.validation.VError;
import net.exathunk.jsubschema.validation.Validator;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.util.Set;

/**
 * charolastra 11/27/12 2:54 PM
 */
public class Reader {

    public static void runReader() throws IOException, TypeException {
        Session session = Session.loadDefaultSession();

        // TODO unfk
        JsonNode schemaNode = Loader.loadNode("/nonlocal/schema");
        SchemaLike schemaSchema = Util.quickBind(schemaNode, new SchemaFactory());
        session.addSchema(schemaSchema);

        VContext context = session.validate();
        if (!context.errors.isEmpty()) {
            VError.throwAll(context.errors);
        }

        // run all the normal validations
        {
          Validator validator = new InstanceValidator();
          runReader(session, validator);
        }

        // now validate late refs
        {
            LateRefResolver lateRefResolver = new MultiLateRefResolver(Util.asList(
                    new LoaderLateRefResolver("http://exathunk.net/farce"),
                    new SingleLateRefResolver("http://exathunk.net/schemas/schema", Loader.loadNode("/nonlocal/schema"))));
            Validator validator = new LateRefValidator(session, lateRefResolver, new InstanceValidator());
            runReader(session, validator);
        }
    }

    private static void runReader(Session session, Validator validator) throws IOException, TypeException {
        Set<String> instanceTypes = Loader.listFiles("/instances");

        for (String instanceType : instanceTypes) {
            System.out.println("Processing instance type: "+instanceType);
            SchemaLike schema = Loader.loadSchema(instanceType);
            Set<String> instances = Loader.listFiles("/instances/"+instanceType);
            for (String instance : instances) {
                System.out.println("Processing instance: "+instance);
                JsonNode node = Loader.loadNode("/instances/"+instanceType+"/"+instance);
                VContext context = Util.runValidator(validator, session, schema, node);
                if (!context.errors.isEmpty()) {
                    VError.throwAll(context.errors);
                }
            }
        }
    }
}
