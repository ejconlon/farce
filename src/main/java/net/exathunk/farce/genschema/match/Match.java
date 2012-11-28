package net.exathunk.farce.genschema.match;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;

public class Match implements Cloneable, Serializable, MatchLike {

    private String schema;

    private Map<String, String> substitutions;

    private String templateString;

    @Override
    public boolean hasSchema() {
        return null != schema;
    }

    @Override
    public String getSchema() {
        return schema;
    }

    @Override
    public void setSchema(String schema) {
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
    public boolean hasTemplateString() {
        return null != templateString;
    }

    @Override
    public String getTemplateString() {
        return templateString;
    }

    @Override
    public void setTemplateString(String templateString) {
        this.templateString = templateString;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Match{ ");
        if (schema != null) sb.append("schema='").append(schema).append("', ");
        if (substitutions != null) sb.append("substitutions='").append(substitutions).append("', ");
        if (templateString != null) sb.append("templateString='").append(templateString).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof MatchLike) {
            MatchLike other = (MatchLike) o;
            if (schema == null) { if (other.hasSchema()) { return false; } }
            else if (!schema.equals(other.getSchema())) { return false; }
            if (substitutions == null) { if (other.hasSubstitutions()) { return false; } }
            else if (!substitutions.equals(other.getSubstitutions())) { return false; }
            if (templateString == null) { if (other.hasTemplateString()) { return false; } }
            else if (!templateString.equals(other.getTemplateString())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (schema == null ? 0 : schema.hashCode());
        result = 31 * result + (substitutions == null ? 0 : substitutions.hashCode());
        result = 31 * result + (templateString == null ? 0 : templateString.hashCode());
        return result;
    }

    public Set<String> diff(MatchLike other) {
            Set<String> s = new TreeSet<String>();
            if (schema == null) { if (other == null || other.hasSchema()) { s.add("schema"); } }
            else if (!schema.equals(other.getSchema())) { s.add("schema"); }
            if (substitutions == null) { if (other == null || other.hasSubstitutions()) { s.add("substitutions"); } }
            else if (!substitutions.equals(other.getSubstitutions())) { s.add("substitutions"); }
            if (templateString == null) { if (other == null || other.hasTemplateString()) { s.add("templateString"); } }
            else if (!templateString.equals(other.getTemplateString())) { s.add("templateString"); }
            return s;
    }

}
