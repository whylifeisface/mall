package com.example.mall.mbg.model.pms;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PmsProductAttributeCategory implements Serializable {
    private Long id;

    private String name;

    @ApiModelProperty(value = "属性数量")
    private Integer attributeCount;

    @ApiModelProperty(value = "参数数量")
    private Integer paramCount;

    private List<PmsProductCategory> pmsProductCategory;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "PmsProductAttributeCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attributeCount=" + attributeCount +
                ", paramCount=" + paramCount +
                ", pmsProductCategory=" + pmsProductCategory +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(Integer attributeCount) {
        this.attributeCount = attributeCount;
    }

    public Integer getParamCount() {
        return paramCount;
    }

    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    public List<PmsProductCategory> getPmsProductCategory() {
        return pmsProductCategory;
    }

    public void setPmsProductCategory(List<PmsProductCategory> pmsProductCategory) {
        this.pmsProductCategory = pmsProductCategory;
    }
}
