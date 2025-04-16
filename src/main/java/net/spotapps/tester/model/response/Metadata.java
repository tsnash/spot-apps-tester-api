package net.spotapps.tester.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "serviceName",
        "statusCode",
        "statusDescription",
})
public class Metadata implements Serializable {

    @JsonProperty("serviceName")
    @ApiModelProperty(notes = "The name of the service that provided this response.")
    private String serviceName;

    @JsonProperty("statusCode")
    @ApiModelProperty(notes = "The status code associated with this response.")
    private String statusCode;

    @JsonProperty("statusDescription")
    @ApiModelProperty(notes = "The status message associated with this response.")
    private String statusDescription;

    public Metadata() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
        result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
        result = prime * result + ((statusDescription == null) ? 0 : statusDescription.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Metadata other = (Metadata) obj;
        if (serviceName == null) {
            if (other.serviceName != null)
                return false;
        } else if (!serviceName.equals(other.serviceName))
            return false;
        if (statusCode == null) {
            if (other.statusCode != null)
                return false;
        } else if (!statusCode.equals(other.statusCode))
            return false;
        if (statusDescription == null) {
            if (other.statusDescription != null)
                return false;
        } else if (!statusDescription.equals(other.statusDescription))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Metadata [serviceName=" + serviceName + ", statusCode=" + statusCode + ", statusDescription="
                + statusDescription + "]";
    }
    

}
