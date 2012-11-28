package net.exathunk.farce.genschema.error;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;

public class Error implements Cloneable, Serializable, ErrorLike {

    private MatchLike data;

    private String message;

    @Override
    public boolean hasData() {
        return null != data;
    }

    @Override
    public MatchLike getData() {
        return data;
    }

    @Override
    public void setData(MatchLike data) {
        this.data = data;
    }

    @Override
    public boolean hasMessage() {
        return null != message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Error{ ");
        if (data != null) sb.append("data='").append(data).append("', ");
        if (message != null) sb.append("message='").append(message).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ErrorLike) {
            ErrorLike other = (ErrorLike) o;
            if (data == null) { if (other.hasData()) { return false; } }
            else if (!data.equals(other.getData())) { return false; }
            if (message == null) { if (other.hasMessage()) { return false; } }
            else if (!message.equals(other.getMessage())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (data == null ? 0 : data.hashCode());
        result = 31 * result + (message == null ? 0 : message.hashCode());
        return result;
    }

    public Set<String> diff(ErrorLike other) {
            Set<String> s = new TreeSet<String>();
            if (data == null) { if (other == null || other.hasData()) { s.add("data"); } }
            else if (!data.equals(other.getData())) { s.add("data"); }
            if (message == null) { if (other == null || other.hasMessage()) { s.add("message"); } }
            else if (!message.equals(other.getMessage())) { s.add("message"); }
            return s;
    }

}
