package net.exathunk.farce.reader;

import net.exathunk.jsubschema.Util;
import net.exathunk.jsubschema.base.Session;
import net.exathunk.jsubschema.base.TypeException;
import net.exathunk.jsubschema.gen.Loader;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import net.exathunk.jsubschema.validation.DefaultValidator;
import net.exathunk.jsubschema.validation.VContext;
import net.exathunk.jsubschema.validation.VError;
import net.exathunk.jsubschema.validation.Validator;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.util.Set;

/**
 * charolastra 11/27/12 2:54 PM
 */
public class RunReader {
    public static void main(String[] args) throws IOException, TypeException {
        Session session = Session.loadDefaultSession();
        Set<String> instanceTypes = Loader.listFiles("/instances");
        Validator validator = new DefaultValidator();
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
