package net.exathunk.farce.genschema.applicationkeys;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;

public class ApplicationKeys implements Cloneable, Serializable, ApplicationKeysLike {

    private String applicationId;

    private String restApiKey;

    @Override
    public boolean hasApplicationId() {
        return null != applicationId;
    }

    @Override
    public String getApplicationId() {
        return applicationId;
    }

    @Override
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public boolean hasRestApiKey() {
        return null != restApiKey;
    }

    @Override
    public String getRestApiKey() {
        return restApiKey;
    }

    @Override
    public void setRestApiKey(String restApiKey) {
        this.restApiKey = restApiKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ApplicationKeys{ ");
        if (applicationId != null) sb.append("applicationId='").append(applicationId).append("', ");
        if (restApiKey != null) sb.append("restApiKey='").append(restApiKey).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ApplicationKeysLike) {
            ApplicationKeysLike other = (ApplicationKeysLike) o;
            if (applicationId == null) { if (other.hasApplicationId()) { return false; } }
            else if (!applicationId.equals(other.getApplicationId())) { return false; }
            if (restApiKey == null) { if (other.hasRestApiKey()) { return false; } }
            else if (!restApiKey.equals(other.getRestApiKey())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (applicationId == null ? 0 : applicationId.hashCode());
        result = 31 * result + (restApiKey == null ? 0 : restApiKey.hashCode());
        return result;
    }

    public Set<String> diff(ApplicationKeysLike other) {
            Set<String> s = new TreeSet<String>();
            if (applicationId == null) { if (other == null || other.hasApplicationId()) { s.add("applicationId"); } }
            else if (!applicationId.equals(other.getApplicationId())) { s.add("applicationId"); }
            if (restApiKey == null) { if (other == null || other.hasRestApiKey()) { s.add("restApiKey"); } }
            else if (!restApiKey.equals(other.getRestApiKey())) { s.add("restApiKey"); }
            return s;
    }

}
