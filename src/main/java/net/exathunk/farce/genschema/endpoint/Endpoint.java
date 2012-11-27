package net.exathunk.farce.genschema.endpoint;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import net.exathunk.farce.genschema.request.Request;
import net.exathunk.farce.genschema.request.RequestLike;
import net.exathunk.farce.genschema.response.Response;
import net.exathunk.farce.genschema.response.ResponseLike;

public class Endpoint implements Cloneable, Serializable, EndpointLike {

    private String description;

    private RequestLike request;

    private List<ResponseLike> responses;

    @Override
    public boolean hasDescription() {
        return null != description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean hasRequest() {
        return null != request;
    }

    @Override
    public RequestLike getRequest() {
        return request;
    }

    @Override
    public void setRequest(RequestLike request) {
        this.request = request;
    }

    @Override
    public boolean hasResponses() {
        return null != responses;
    }

    @Override
    public List<ResponseLike> getResponses() {
        return responses;
    }

    @Override
    public void setResponses(List<ResponseLike> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Endpoint{ ");
        if (description != null) sb.append("description='").append(description).append("', ");
        if (request != null) sb.append("request='").append(request).append("', ");
        if (responses != null) sb.append("responses='").append(responses).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof EndpointLike) {
            EndpointLike other = (EndpointLike) o;
            if (description == null) { if (other.hasDescription()) { return false; } }
            else if (!description.equals(other.getDescription())) { return false; }
            if (request == null) { if (other.hasRequest()) { return false; } }
            else if (!request.equals(other.getRequest())) { return false; }
            if (responses == null) { if (other.hasResponses()) { return false; } }
            else if (!responses.equals(other.getResponses())) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (description == null ? 0 : description.hashCode());
        result = 31 * result + (request == null ? 0 : request.hashCode());
        result = 31 * result + (responses == null ? 0 : responses.hashCode());
        return result;
    }

    public Set<String> diff(EndpointLike other) {
            Set<String> s = new TreeSet<String>();
            if (description == null) { if (other == null || other.hasDescription()) { s.add("description"); } }
            else if (!description.equals(other.getDescription())) { s.add("description"); }
            if (request == null) { if (other == null || other.hasRequest()) { s.add("request"); } }
            else if (!request.equals(other.getRequest())) { s.add("request"); }
            if (responses == null) { if (other == null || other.hasResponses()) { s.add("responses"); } }
            else if (!responses.equals(other.getResponses())) { s.add("responses"); }
            return s;
    }

}
