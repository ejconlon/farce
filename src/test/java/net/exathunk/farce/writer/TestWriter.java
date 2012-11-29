package net.exathunk.farce.writer;

import net.exathunk.farce.util.SessionLoader;
import net.exathunk.jsubschema.Util;
import net.exathunk.jsubschema.base.Session;
import net.exathunk.jsubschema.base.TypeException;
import net.exathunk.jsubschema.genschema.schema.SchemaFactory;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import net.exathunk.jsubschema.validation.*;
import org.codehaus.jackson.JsonNode;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * charolastra 11/27/12 9:24 PM
 */
public class TestWriter {
    @Test
    public void testTranslate() throws IOException, TypeException {
        final String source = "{\n" +
                "  \"method\": \"POST\",\n" +
                "  \"path\": {\n" +
                "    \"templateString\": \"/1/classes/{{className}}\",\n" +
                "    \"schema\": \"http://exathunk.net/farce/schemas/className\"\n" +
                "  },\n" +
                "  \"headers\": {\n" +
                "    \"Content-Type\": {\n" +
                "      \"templateString\": \"application/json\"\n" +
                "    },\n" +
                "    \"X-Parse-Application-Id\" : {\n" +
                "      \"templateString\": \"{{applicationId}}\",\n" +
                "      \"schema\": \"http://exathunk.net/farce/schemas/applicationKeys\"\n" +
                "    },\n" +
                "    \"X-Parse-REST-API-Key\": {\n" +
                "      \"templateString\": \"{{restApiKey}}\",\n" +
                "      \"schema\": \"http://exathunk.net/farce/schemas/applicationKeys\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"schema\": \"http://exathunk.net/schemas/schema\"\n" +
                "}";
        final String sink = "{\n" +
                "  \"id\": \"http://exathunk.net/farce/genschemas/request/createObject\",\n" +
                "  \"type\": \"object\",\n" +
                "  \"required\": [\"data\", \"headers\", \"path\"],\n" +
                "\n" +
                "  \"properties\": {\n" +
                "    \"path\": {\n" +
                "      \"$ref\": \"http://exathunk.net/farce/schemas/className\"\n" +
                "    },\n" +
                "    \"headers\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"required\": [\"X-Parse-Application-Id\", \"X-Parse-REST-API-Key\"],\n" +
                "      \"properties\": {\n" +
                "        \"X-Parse-Application-Id\": {\n" +
                "          \"$ref\": \"http://exathunk.net/farce/schemas/applicationKeys\"\n" +
                "        },\n" +
                "        \"X-Parse-REST-API-Key\": {\n" +
                "          \"$ref\": \"http://exathunk.net/farce/schemas/applicationKeys\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"data\": {\n" +
                "      \"$ref\": \"http://exathunk.net/schemas/schema\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // source is an instance and should validate as such.
        // sink is a schema ''

        Session session = SessionLoader.loadDefaultSession();
        SchemaLike metaSchema = session.schemas.get("http://exathunk.net/schemas/schema");
        assertNotNull(metaSchema);
        SchemaLike requestSchema = session.schemas.get("http://exathunk.net/farce/schemas/request");
        assertNotNull(requestSchema);

        Validator instanceValidator = new InstanceValidator();
        JsonNode sourceNode = Util.parse(source);
        VContext sourceContext = Util.runValidator(instanceValidator, session, requestSchema, sourceNode);
        if (!sourceContext.errors.isEmpty()) VError.throwAll(sourceContext.errors);

        Validator schemaValidator = new SchemaValidator();
        JsonNode sinkNode = Util.parse(sink);
        VContext sinkContext = Util.runValidator(schemaValidator, session, metaSchema, sinkNode);
        if (!sinkContext.errors.isEmpty()) VError.throwAll(sinkContext.errors);

        SchemaLike goldReSchema = Util.quickBind(sinkNode, new SchemaFactory());
        SchemaLike testReSchema = Writer.reify("http://exathunk.net/farce/genschemas/request/createObject", "schema", "data", sourceNode);

        assertEquals(goldReSchema, testReSchema);
    }
}
