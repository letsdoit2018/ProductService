
package com.letsdoit.core.product.domain;

import java.util.LinkedHashMap;
import java.util.List;
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
    "platform_product_supplier_id",
    "platform_product_descriprtion",
    "product_categories"
})
@Generated("jsonschema2pojo")
public class Product {

    //Need clarification on the id field
    @Id
    private String id;

    @JsonProperty("platform_product_supplier_id")
    private String platformProductSupplierId;
    @JsonProperty("platform_product_descriprtion")
    private String platformProductDescriprtion;
    @JsonProperty("product_categories")
    private List<ProductCategory> productCategories;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("platform_product_supplier_id")
    public String getPlatformProductSupplierId() {
        return platformProductSupplierId;
    }

    @JsonProperty("platform_product_supplier_id")
    public void setPlatformProductSupplierId(String platformProductSupplierId) {
        this.platformProductSupplierId = platformProductSupplierId;
    }

    public Product withPlatformProductSupplierId(String platformProductSupplierId) {
        this.platformProductSupplierId = platformProductSupplierId;
        return this;
    }

    @JsonProperty("platform_product_descriprtion")
    public String getPlatformProductDescriprtion() {
        return platformProductDescriprtion;
    }

    @JsonProperty("platform_product_descriprtion")
    public void setPlatformProductDescriprtion(String platformProductDescriprtion) {
        this.platformProductDescriprtion = platformProductDescriprtion;
    }

    public Product withPlatformProductDescriprtion(String platformProductDescriprtion) {
        this.platformProductDescriprtion = platformProductDescriprtion;
        return this;
    }

    @JsonProperty("product_categories")
    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    @JsonProperty("product_categories")
    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public Product withProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
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

    public Product withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Product.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("platformProductSupplierId");
        sb.append('=');
        sb.append(((this.platformProductSupplierId == null)?"<null>":this.platformProductSupplierId));
        sb.append(',');
        sb.append("platformProductDescriprtion");
        sb.append('=');
        sb.append(((this.platformProductDescriprtion == null)?"<null>":this.platformProductDescriprtion));
        sb.append(',');
        sb.append("productCategories");
        sb.append('=');
        sb.append(((this.productCategories == null)?"<null>":this.productCategories));
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
        result = ((result* 31)+((this.productCategories == null)? 0 :this.productCategories.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.platformProductDescriprtion == null)? 0 :this.platformProductDescriprtion.hashCode()));
        result = ((result* 31)+((this.platformProductSupplierId == null)? 0 :this.platformProductSupplierId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return (((((this.productCategories == rhs.productCategories)||((this.productCategories!= null)&&this.productCategories.equals(rhs.productCategories)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.platformProductDescriprtion == rhs.platformProductDescriprtion)||((this.platformProductDescriprtion!= null)&&this.platformProductDescriprtion.equals(rhs.platformProductDescriprtion))))&&((this.platformProductSupplierId == rhs.platformProductSupplierId)||((this.platformProductSupplierId!= null)&&this.platformProductSupplierId.equals(rhs.platformProductSupplierId))));
    }

}
