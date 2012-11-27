package net.exathunk.farce.genschema.response;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.headers.Headers;
import net.exathunk.farce.genschema.headers.HeadersLike;
import net.exathunk.farce.genschema.schema.Schema;
import net.exathunk.farce.genschema.schema.SchemaLike;

public class Response implements Cloneable, Serializable, ResponseLike {

    private Long code;

    private HeadersLike headers;

    private SchemaLike schema;

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
        StringBuilder sb = new StringBuilder("Response{ ");
        if (code != null) sb.append("code='").append(code).append("', ");
        if (headers != null) sb.append("headers='").append(headers).append("', ");
        if (schema != null) sb.append("schema='").append(schema).append("', ");
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
        result = 31 * result + (code == null ? 0 : code.hashCode());
        result = 31 * result + (headers == null ? 0 : headers.hashCode());
        result = 31 * result + (schema == null ? 0 : schema.hashCode());
        return result;
    }

    public Set<String> diff(ResponseLike other) {
            Set<String> s = new TreeSet<String>();
            if (code == null) { if (other == null || other.hasCode()) { s.add("code"); } }
            else if (!code.equals(other.getCode())) { s.add("code"); }
            if (headers == null) { if (other == null || other.hasHeaders()) { s.add("headers"); } }
            else if (!headers.equals(other.getHeaders())) { s.add("headers"); }
            if (schema == null) { if (other == null || other.hasSchema()) { s.add("schema"); } }
            else if (!schema.equals(other.getSchema())) { s.add("schema"); }
            return s;
    }

}
