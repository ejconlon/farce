package net.exathunk.farce.util;

import net.exathunk.jsubschema.Util;
import net.exathunk.jsubschema.base.Session;
import net.exathunk.jsubschema.base.TypeException;
import net.exathunk.jsubschema.gen.Loader;
import net.exathunk.jsubschema.genschema.schema.SchemaFactory;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import org.codehaus.jackson.JsonNode;

import java.io.IOException;

/**
 * charolastra 11/29/12 11:22 AM
 */
public class SessionLoader {
    public static Session loadDefaultSession() throws IOException, TypeException {
        Session session = Session.loadDefaultSession();

        // TODO unfk
        JsonNode schemaNode = Loader.loadNode("/nonlocal/schema");
        SchemaLike schemaSchema = Util.quickBind(schemaNode, new SchemaFactory());
        session.addSchema(schemaSchema);

        return session;
    }
}
