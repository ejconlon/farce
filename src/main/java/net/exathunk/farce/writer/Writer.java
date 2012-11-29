package net.exathunk.farce.writer;

import net.exathunk.jsubschema.Util;
import net.exathunk.jsubschema.base.TypeException;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;
import net.exathunk.jsubschema.genschema.schema.declarations.keylist.KeyList;
import org.codehaus.jackson.JsonNode;

import java.util.TreeMap;

/**
 * charolastra 11/27/12 9:27 PM
 */
public class Writer {

    public static SchemaLike reify(String id, String schemaKey, String dataKey, JsonNode node) throws TypeException {
        if (!node.isObject()) throw new TypeException("Need root object");
        SchemaLike schema = new Schema();
        schema.setId(id);
        schema.setType("object");
        for (String key : Util.onceIterable(node.getFieldNames())) {
            JsonNode subNode = node.get(key);
            if (key.equals(schemaKey)) {
                addProperty(schema, dataKey, makeRefSchema(subNode));
            } else {
                if (subNode.isObject()) {
                    SchemaLike subSchema = reify(id, schemaKey, dataKey, subNode);
                    subSchema.setId(null);
                    if (subSchema.hasProperties() || subSchema.has__dollar__ref()) {
                        addProperty(schema, key, subSchema);
                    }
                }
            }
        }
        if (schema.hasProperties() && schema.getProperties().size() == 1) {
            SchemaLike subSchema = schema.getProperties().values().iterator().next();
            if (subSchema.has__dollar__ref()) {
                schema.set__dollar__ref(subSchema.get__dollar__ref());
                schema.setProperties(null);
                schema.setType(null);
            }
        }
        if (schema.hasProperties()) {
            schema.setRequired(new KeyList());
            schema.getRequired().addAll(schema.getProperties().keySet());
        }
        return schema;
    }

    private static SchemaLike makeRefSchema(JsonNode node) throws TypeException {
        if (!node.isTextual()) throw new TypeException("Need textual ref");
        SchemaLike schema = new Schema();
        schema.set__dollar__ref(node.asText());
        return schema;
    }

    private static void addProperty(SchemaLike schema, String key, SchemaLike value) {
        if (!schema.hasProperties()) schema.setProperties(new TreeMap<String, SchemaLike>());
        schema.getProperties().put(key, value);
    }
}
