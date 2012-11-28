package net.exathunk.farce.genschema.location;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;

public class Location implements Cloneable, Serializable, LocationLike {

    private String location;

    @Override
    public boolean hasLocation() {
        return null != location;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Location{ ");
        if (location != null) sb.append("location='").append(location).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof LocationLike) {
            LocationLike other = (LocationLike) o;
            if (location == null) { if (other.hasLocation()) { return false; } }
            else if (!location.equals(other.getLocation())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (location == null ? 0 : location.hashCode());
        return result;
    }

    public Set<String> diff(LocationLike other) {
            Set<String> s = new TreeSet<String>();
            if (location == null) { if (other == null || other.hasLocation()) { s.add("location"); } }
            else if (!location.equals(other.getLocation())) { s.add("location"); }
            return s;
    }

}
