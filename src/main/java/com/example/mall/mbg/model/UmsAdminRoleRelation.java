package com.example.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

public class UmsAdminRoleRelation implements Serializable {
    private Long id;

    private Long adminId;

    @Override
    public String toString() {
        return "UmsAdminRoleRelation{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", roleId=" + roleId +
                ", umsRole=" + umsRole +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public UmsRole getUmsRole() {
        return umsRole;
    }

    public void setUmsRole(UmsRole umsRole) {
        this.umsRole = umsRole;
    }

    private Long roleId;

    private UmsRole umsRole;

    private static final long serialVersionUID = 1L;


}