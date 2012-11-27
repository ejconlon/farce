package net.exathunk.farce.genschema.response;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.headers.Headers;
import net.exathunk.farce.genschema.headers.HeadersLike;
import net.exathunk.farce.genschema.schemaref.Schemaref;
import net.exathunk.farce.genschema.schemaref.SchemarefLike;

public class Response implements Cloneable, Serializable, ResponseLike {

    private Long code;

    private HeadersLike headers;

    private SchemarefLike schemaref;

    @Override
    public boolean hasCode() {
        return null != code;
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public boolean hasHeaders() {
        return null != headers;
    }

    @Override
    public HeadersLike getHeaders() {
        return headers;
    }

    @Override
    public void setHeaders(HeadersLike headers) {
        this.headers = headers;
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
    public String toString() {
        StringBuilder sb = new StringBuilder("Response{ ");
        if (code != null) sb.append("code='").append(code).append("', ");
        if (headers != null) sb.append("headers='").append(headers).append("', ");
        if (schemaref != null) sb.append("schemaref='").append(schemaref).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ResponseLike) {
            ResponseLike other = (ResponseLike) o;
            if (code == null) { if (other.hasCode()) { return false; } }
            else if (!code.equals(other.getCode())) { return false; }
            if (headers == null) { if (other.hasHeaders()) { return false; } }
            else if (!headers.equals(other.getHeaders())) { return false; }
            if (schemaref == null) { if (other.hasSchemaref()) { return false; } }
            else if (!schemaref.equals(other.getSchemaref())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (code == null ? 0 : code.hashCode());
        result = 31 * result + (headers == null ? 0 : headers.hashCode());
        result = 31 * result + (schemaref == null ? 0 : schemaref.hashCode());
        return result;
    }

    public Set<String> diff(ResponseLike other) {
            Set<String> s = new TreeSet<String>();
            if (code == null) { if (other == null || other.hasCode()) { s.add("code"); } }
            else if (!code.equals(other.getCode())) { s.add("code"); }
            if (headers == null) { if (other == null || other.hasHeaders()) { s.add("headers"); } }
            else if (!headers.equals(other.getHeaders())) { s.add("headers"); }
            if (schemaref == null) { if (other == null || other.hasSchemaref()) { s.add("schemaref"); } }
            else if (!schemaref.equals(other.getSchemaref())) { s.add("schemaref"); }
            return s;
    }

}
