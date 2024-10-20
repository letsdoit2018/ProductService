
package com.letsdoit.core.product.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partner_variant",
    "auditInfo"
})
@Generated("jsonschema2pojo")
public class Variants {

    @Id
    private String id;

    //getter setter method for id
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("partner_variant")
    private PartnerVariant partnerVariant;
    @JsonProperty("auditInfo")
    private AuditInfo auditInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("partner_variant")
    public PartnerVariant getPartnerVariant() {
        return partnerVariant;
    }

    @JsonProperty("partner_variant")
    public void setPartnerVariant(PartnerVariant partnerVariant) {
        this.partnerVariant = partnerVariant;
    }

    public Variants withPartnerVariant(PartnerVariant partnerVariant) {
        this.partnerVariant = partnerVariant;
        return this;
    }

    @JsonProperty("auditInfo")
    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    @JsonProperty("auditInfo")
    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Variants withAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Variants withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Variants.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("partnerVariant");
        sb.append('=');
        sb.append(((this.partnerVariant == null)?"<null>":this.partnerVariant));
        sb.append(',');
        sb.append("auditInfo");
        sb.append('=');
        sb.append(((this.auditInfo == null)?"<null>":this.auditInfo));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.auditInfo == null)? 0 :this.auditInfo.hashCode()));
        result = ((result* 31)+((this.partnerVariant == null)? 0 :this.partnerVariant.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Variants) == false) {
            return false;
        }
        Variants rhs = ((Variants) other);
        return ((((this.auditInfo == rhs.auditInfo)||((this.auditInfo!= null)&&this.auditInfo.equals(rhs.auditInfo)))&&((this.partnerVariant == rhs.partnerVariant)||((this.partnerVariant!= null)&&this.partnerVariant.equals(rhs.partnerVariant))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
