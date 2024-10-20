
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "product_id",
    "product_description",
    "product_category"
})
@Generated("jsonschema2pojo")
public class ProductCategory {

    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("product_description")
    private String productDescription;
    @JsonProperty("product_category")
    private String productCategory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("product_id")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("product_id")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ProductCategory withProductId(String productId) {
        this.productId = productId;
        return this;
    }

    @JsonProperty("product_description")
    public String getProductDescription() {
        return productDescription;
    }

    @JsonProperty("product_description")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ProductCategory withProductDescription(String productDescription) {
        this.productDescription = productDescription;
        return this;
    }

    @JsonProperty("product_category")
    public String getProductCategory() {
        return productCategory;
    }

    @JsonProperty("product_category")
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public ProductCategory withProductCategory(String productCategory) {
        this.productCategory = productCategory;
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

    public ProductCategory withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProductCategory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null)?"<null>":this.productId));
        sb.append(',');
        sb.append("productDescription");
        sb.append('=');
        sb.append(((this.productDescription == null)?"<null>":this.productDescription));
        sb.append(',');
        sb.append("productCategory");
        sb.append('=');
        sb.append(((this.productCategory == null)?"<null>":this.productCategory));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.productId == null)? 0 :this.productId.hashCode()));
        result = ((result* 31)+((this.productDescription == null)? 0 :this.productDescription.hashCode()));
        result = ((result* 31)+((this.productCategory == null)? 0 :this.productCategory.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductCategory) == false) {
            return false;
        }
        ProductCategory rhs = ((ProductCategory) other);
        return (((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.productId == rhs.productId)||((this.productId!= null)&&this.productId.equals(rhs.productId))))&&((this.productDescription == rhs.productDescription)||((this.productDescription!= null)&&this.productDescription.equals(rhs.productDescription))))&&((this.productCategory == rhs.productCategory)||((this.productCategory!= null)&&this.productCategory.equals(rhs.productCategory))));
    }

}
