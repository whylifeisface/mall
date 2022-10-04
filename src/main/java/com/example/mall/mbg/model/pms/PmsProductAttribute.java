package com.example.mall.mbg.model.pms;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

public class PmsProductAttribute implements Serializable {
    private Long id;

    private Long productAttributeCategoryId;

    private String name;

    @ApiModelProperty(value = "属性选择类型：0->唯一；1->单选；2->多选")
    private Integer selectType;

    @ApiModelProperty(value = "属性录入方式：0->手工录入；1->从列表中选取")
    private Integer inputType;

    @ApiModelProperty(value = "可选值列表，以逗号隔开")
    private String inputList;

    @ApiModelProperty(value = "排序字段：最高的可以单独上传图片")
    private Integer sort;

    @ApiModelProperty(value = "分类筛选样式：1->普通；1->颜色")
    private Integer filterType;

    @ApiModelProperty(value = "检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
    private Integer searchType;

    @ApiModelProperty(value = "相同属性产品是否关联；0->不关联；1->关联")
    private Integer relatedStatus;

    @ApiModelProperty(value = "是否支持手动新增；0->不支持；1->支持")
    private Integer handAddStatus;

    @ApiModelProperty(value = "属性的类型；0->规格；1->参数")
    private Integer type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PmsProductAttribute that = (PmsProductAttribute) o;
        return Objects.equals(id, that.id) && Objects.equals(productAttributeCategoryId, that.productAttributeCategoryId) && Objects.equals(name, that.name) && Objects.equals(selectType, that.selectType) && Objects.equals(inputType, that.inputType) && Objects.equals(inputList, that.inputList) && Objects.equals(sort, that.sort) && Objects.equals(filterType, that.filterType) && Objects.equals(searchType, that.searchType) && Objects.equals(relatedStatus, that.relatedStatus) && Objects.equals(handAddStatus, that.handAddStatus) && Objects.equals(type, that.type) && Objects.equals(pmsProductAttributeCategory, that.pmsProductAttributeCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productAttributeCategoryId, name, selectType, inputType, inputList, sort, filterType, searchType, relatedStatus, handAddStatus, type, pmsProductAttributeCategory);
    }

    private PmsProductAttributeCategory pmsProductAttributeCategory;

    @Override
    public String toString() {
        return "PmsProductAttribute{" +
                "id=" + id +
                ", productAttributeCategoryId=" + productAttributeCategoryId +
                ", name='" + name + '\'' +
                ", selectType=" + selectType +
                ", inputType=" + inputType +
                ", inputList='" + inputList + '\'' +
                ", sort=" + sort +
                ", filterType=" + filterType +
                ", searchType=" + searchType +
                ", relatedStatus=" + relatedStatus +
                ", handAddStatus=" + handAddStatus +
                ", type=" + type +
                ", pmsProductAttributeCategory=" + pmsProductAttributeCategory +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public PmsProductAttributeCategory getPmsProductAttributeCategory() {
        return pmsProductAttributeCategory;
    }

    public void setPmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory) {
        this.pmsProductAttributeCategory = pmsProductAttributeCategory;
    }
}