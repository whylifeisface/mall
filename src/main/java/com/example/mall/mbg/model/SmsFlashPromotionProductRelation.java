package com.example.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class SmsFlashPromotionProductRelation implements Serializable {
    @ApiModelProperty(value = "编号")
    private Long id;
    private int numberCount;
    private SmsFlashPromotionSession smsFlashPromotionSession;
    private Long flashPromotionId;
    private PmsProduct pmsProduct;
    @ApiModelProperty(value = "编号")
    private Long flashPromotionSessionId;

    private Long productId;

    @ApiModelProperty(value = "限时购价格")
    private BigDecimal flashPromotionPrice;

    @ApiModelProperty(value = "限时购数量")
    private Integer flashPromotionCount;

    @ApiModelProperty(value = "每人限购数量")
    private Integer flashPromotionLimit;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }


}