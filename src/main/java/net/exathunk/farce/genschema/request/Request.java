package net.exathunk.farce.genschema.request;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.headers.Headers;
import net.exathunk.farce.genschema.headers.HeadersLike;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.jsubschema.genschema.schema.Schema;
import net.exathunk.jsubschema.genschema.schema.SchemaLike;

public class Request implements Cloneable, Serializable, RequestLike {

    private HeadersLike headers;

    private String method;

    private MatchLike path;

    private String schema;

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
    public boolean hasMethod() {
        return null != method;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean hasPath() {
        return null != path;
    }

    @Override
    public MatchLike getPath() {
        return path;
    }

    @Override
    public void setPath(MatchLike path) {
        this.path = path;
    }

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
    public String toString() {
        StringBuilder sb = new StringBuilder("Request{ ");
        if (headers != null) sb.append("headers='").append(headers).append("', ");
        if (method != null) sb.append("method='").append(method).append("', ");
        if (path != null) sb.append("path='").append(path).append("', ");
        if (schema != null) sb.append("schema='").append(schema).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof RequestLike) {
            RequestLike other = (RequestLike) o;
            if (headers == null) { if (other.hasHeaders()) { return false; } }
            else if (!headers.equals(other.getHeaders())) { return false; }
            if (method == null) { if (other.hasMethod()) { return false; } }
            else if (!method.equals(other.getMethod())) { return false; }
            if (path == null) { if (other.hasPath()) { return false; } }
            else if (!path.equals(other.getPath())) { return false; }
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
        result = 31 * result + (headers == null ? 0 : headers.hashCode());
        result = 31 * result + (method == null ? 0 : method.hashCode());
        result = 31 * result + (path == null ? 0 : path.hashCode());
        result = 31 * result + (schema == null ? 0 : schema.hashCode());
        return result;
    }

    public Set<String> diff(RequestLike other) {
            Set<String> s = new TreeSet<String>();
            if (headers == null) { if (other == null || other.hasHeaders()) { s.add("headers"); } }
            else if (!headers.equals(other.getHeaders())) { s.add("headers"); }
            if (method == null) { if (other == null || other.hasMethod()) { s.add("method"); } }
            else if (!method.equals(other.getMethod())) { s.add("method"); }
            if (path == null) { if (other == null || other.hasPath()) { s.add("path"); } }
            else if (!path.equals(other.getPath())) { s.add("path"); }
            if (schema == null) { if (other == null || other.hasSchema()) { s.add("schema"); } }
            else if (!schema.equals(other.getSchema())) { s.add("schema"); }
            return s;
    }

}
