package com.example.mall.mbg.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class myUmsAdminRoleRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long roleId;

    private List<UmsRole> umsRole;

    private static final long serialVersionUID = 1L;

}
