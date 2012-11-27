package net.exathunk.farce.genschema.headers.declarations.keyvaluepair;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;

public class KeyValuePair implements Cloneable, Serializable, KeyValuePairLike {

    private String key;

    private MatchLike value;

    @Override
    public boolean hasKey() {
        return null != key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean hasValue() {
        return null != value;
    }

    @Override
    public MatchLike getValue() {
        return value;
    }

    @Override
    public void setValue(MatchLike value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("KeyValuePair{ ");
        if (key != null) sb.append("key='").append(key).append("', ");
        if (value != null) sb.append("value='").append(value).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof KeyValuePairLike) {
            KeyValuePairLike other = (KeyValuePairLike) o;
            if (key == null) { if (other.hasKey()) { return false; } }
            else if (!key.equals(other.getKey())) { return false; }
            if (value == null) { if (other.hasValue()) { return false; } }
            else if (!value.equals(other.getValue())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (key == null ? 0 : key.hashCode());
        result = 31 * result + (value == null ? 0 : value.hashCode());
        return result;
    }

    public Set<String> diff(KeyValuePairLike other) {
            Set<String> s = new TreeSet<String>();
            if (key == null) { if (other == null || other.hasKey()) { s.add("key"); } }
            else if (!key.equals(other.getKey())) { s.add("key"); }
            if (value == null) { if (other == null || other.hasValue()) { s.add("value"); } }
            else if (!value.equals(other.getValue())) { s.add("value"); }
            return s;
    }

}
