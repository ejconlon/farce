package net.exathunk.farce.genschema.schemaref;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.schema.Schema;
import net.exathunk.farce.genschema.schema.SchemaLike;

public class Schemaref implements Cloneable, Serializable, SchemarefLike {

    private String ref;

    private SchemaLike schema;

    @Override
    public boolean hasRef() {
        return null != ref;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public boolean hasSchema() {
        return null != schema;
    }

    @Override
    public SchemaLike getSchema() {
        return schema;
    }

    @Override
    public void setSchema(SchemaLike schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Schemaref{ ");
        if (ref != null) sb.append("ref='").append(ref).append("', ");
        if (schema != null) sb.append("schema='").append(schema).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SchemarefLike) {
            SchemarefLike other = (SchemarefLike) o;
            if (ref == null) { if (other.hasRef()) { return false; } }
            else if (!ref.equals(other.getRef())) { return false; }
            if (schema == null) { if (other.hasSchema()) { return false; } }
            else if (!schema.equals(other.getSchema())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (ref == null ? 0 : ref.hashCode());
        result = 31 * result + (schema == null ? 0 : schema.hashCode());
        return result;
    }

    public Set<String> diff(SchemarefLike other) {
            Set<String> s = new TreeSet<String>();
            if (ref == null) { if (other == null || other.hasRef()) { s.add("ref"); } }
            else if (!ref.equals(other.getRef())) { s.add("ref"); }
            if (schema == null) { if (other == null || other.hasSchema()) { s.add("schema"); } }
            else if (!schema.equals(other.getSchema())) { s.add("schema"); }
            return s;
    }

}
