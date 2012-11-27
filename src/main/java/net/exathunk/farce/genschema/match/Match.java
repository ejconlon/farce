package net.exathunk.farce.genschema.match;

import net.exathunk.farce.genschema.schemaref.SchemarefLike;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Match implements Cloneable, Serializable, MatchLike {

    private String path;

    private SchemarefLike schemaref;

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
    public boolean hasSchemaref() {
        return null != schemaref;
    }

    @Override
    public SchemarefLike getSchemaref() {
        return schemaref;
    }

    @Override
    public void setSchemaref(SchemarefLike schemaref) {
        this.schemaref = schemaref;
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
        if (schemaref != null) sb.append("schemaref='").append(schemaref).append("', ");
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
            if (schemaref == null) { if (other.hasSchemaref()) { return false; } }
            else if (!schemaref.equals(other.getSchemaref())) { return false; }
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
        result = 31 * result + (schemaref == null ? 0 : schemaref.hashCode());
        result = 31 * result + (substitutions == null ? 0 : substitutions.hashCode());
        return result;
    }

    public Set<String> diff(MatchLike other) {
            Set<String> s = new TreeSet<String>();
            if (path == null) { if (other == null || other.hasPath()) { s.add("path"); } }
            else if (!path.equals(other.getPath())) { s.add("path"); }
            if (schemaref == null) { if (other == null || other.hasSchemaref()) { s.add("schemaref"); } }
            else if (!schemaref.equals(other.getSchemaref())) { s.add("schemaref"); }
            if (substitutions == null) { if (other == null || other.hasSubstitutions()) { s.add("substitutions"); } }
            else if (!substitutions.equals(other.getSubstitutions())) { s.add("substitutions"); }
            return s;
    }

}
