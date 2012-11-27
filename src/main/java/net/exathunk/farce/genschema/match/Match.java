package net.exathunk.farce.genschema.match;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.schema.Schema;
import net.exathunk.farce.genschema.schema.SchemaLike;

public class Match implements Cloneable, Serializable, MatchLike {

    private String path;

    private SchemaLike schema;

    private Map<String, String> substitutions;

    @Override
    public boolean hasPath() {
        return null != path;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
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
    public boolean hasSubstitutions() {
        return null != substitutions;
    }

    @Override
    public Map<String, String> getSubstitutions() {
        return substitutions;
    }

    @Override
    public void setSubstitutions(Map<String, String> substitutions) {
        this.substitutions = substitutions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Match{ ");
        if (path != null) sb.append("path='").append(path).append("', ");
        if (schema != null) sb.append("schema='").append(schema).append("', ");
        if (substitutions != null) sb.append("substitutions='").append(substitutions).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof MatchLike) {
            MatchLike other = (MatchLike) o;
            if (path == null) { if (other.hasPath()) { return false; } }
            else if (!path.equals(other.getPath())) { return false; }
            if (schema == null) { if (other.hasSchema()) { return false; } }
            else if (!schema.equals(other.getSchema())) { return false; }
            if (substitutions == null) { if (other.hasSubstitutions()) { return false; } }
            else if (!substitutions.equals(other.getSubstitutions())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (path == null ? 0 : path.hashCode());
        result = 31 * result + (schema == null ? 0 : schema.hashCode());
        result = 31 * result + (substitutions == null ? 0 : substitutions.hashCode());
        return result;
    }

    public Set<String> diff(MatchLike other) {
            Set<String> s = new TreeSet<String>();
            if (path == null) { if (other == null || other.hasPath()) { s.add("path"); } }
            else if (!path.equals(other.getPath())) { s.add("path"); }
            if (schema == null) { if (other == null || other.hasSchema()) { s.add("schema"); } }
            else if (!schema.equals(other.getSchema())) { s.add("schema"); }
            if (substitutions == null) { if (other == null || other.hasSubstitutions()) { s.add("substitutions"); } }
            else if (!substitutions.equals(other.getSubstitutions())) { s.add("substitutions"); }
            return s;
    }

}
