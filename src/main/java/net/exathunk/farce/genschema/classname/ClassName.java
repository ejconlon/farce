package net.exathunk.farce.genschema.classname;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;

public class ClassName implements Cloneable, Serializable, ClassNameLike {

    private String className;

    @Override
    public boolean hasClassName() {
        return null != className;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ClassName{ ");
        if (className != null) sb.append("className='").append(className).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ClassNameLike) {
            ClassNameLike other = (ClassNameLike) o;
            if (className == null) { if (other.hasClassName()) { return false; } }
            else if (!className.equals(other.getClassName())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (className == null ? 0 : className.hashCode());
        return result;
    }

    public Set<String> diff(ClassNameLike other) {
            Set<String> s = new TreeSet<String>();
            if (className == null) { if (other == null || other.hasClassName()) { s.add("className"); } }
            else if (!className.equals(other.getClassName())) { s.add("className"); }
            return s;
    }

}
