package net.exathunk.farce.genschema.request;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.headers.Headers;
import net.exathunk.farce.genschema.headers.HeadersLike;
import net.exathunk.farce.genschema.match.Match;
import net.exathunk.farce.genschema.match.MatchLike;
import net.exathunk.farce.genschema.schemaref.Schemaref;
import net.exathunk.farce.genschema.schemaref.SchemarefLike;

public class Request implements Cloneable, Serializable, RequestLike {

    private HeadersLike headers;

    private MatchLike match;

    private String method;

    private SchemarefLike schemaref;

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
    public boolean hasMatch() {
        return null != match;
    }

    @Override
    public MatchLike getMatch() {
        return match;
    }

    @Override
    public void setMatch(MatchLike match) {
        this.match = match;
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
        StringBuilder sb = new StringBuilder("Request{ ");
        if (headers != null) sb.append("headers='").append(headers).append("', ");
        if (match != null) sb.append("match='").append(match).append("', ");
        if (method != null) sb.append("method='").append(method).append("', ");
        if (schemaref != null) sb.append("schemaref='").append(schemaref).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof RequestLike) {
            RequestLike other = (RequestLike) o;
            if (headers == null) { if (other.hasHeaders()) { return false; } }
            else if (!headers.equals(other.getHeaders())) { return false; }
            if (match == null) { if (other.hasMatch()) { return false; } }
            else if (!match.equals(other.getMatch())) { return false; }
            if (method == null) { if (other.hasMethod()) { return false; } }
            else if (!method.equals(other.getMethod())) { return false; }
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
        result = 31 * result + (headers == null ? 0 : headers.hashCode());
        result = 31 * result + (match == null ? 0 : match.hashCode());
        result = 31 * result + (method == null ? 0 : method.hashCode());
        result = 31 * result + (schemaref == null ? 0 : schemaref.hashCode());
        return result;
    }

    public Set<String> diff(RequestLike other) {
            Set<String> s = new TreeSet<String>();
            if (headers == null) { if (other == null || other.hasHeaders()) { s.add("headers"); } }
            else if (!headers.equals(other.getHeaders())) { s.add("headers"); }
            if (match == null) { if (other == null || other.hasMatch()) { s.add("match"); } }
            else if (!match.equals(other.getMatch())) { s.add("match"); }
            if (method == null) { if (other == null || other.hasMethod()) { s.add("method"); } }
            else if (!method.equals(other.getMethod())) { s.add("method"); }
            if (schemaref == null) { if (other == null || other.hasSchemaref()) { s.add("schemaref"); } }
            else if (!schemaref.equals(other.getSchemaref())) { s.add("schemaref"); }
            return s;
    }

}
