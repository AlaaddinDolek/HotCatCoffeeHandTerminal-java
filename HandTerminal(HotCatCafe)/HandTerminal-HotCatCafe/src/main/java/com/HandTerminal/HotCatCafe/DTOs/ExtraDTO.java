package com.HandTerminal.HotCatCafe.DTOs;

import java.math.BigDecimal;

public class ExtraDTO extends BaseEntity{
    
     private String extraName;
    private BigDecimal extraUnitPrice;
    private String categoryName;

    public String getExtraName() {
        return extraName;
    }
    public void setExtraName(String extraName) {
        this.extraName = extraName;
    }
    public BigDecimal getExtraUnitPrice() {
        return extraUnitPrice;
    }
    public void setExtraUnitPrice(BigDecimal extraUnitPrice) {
        this.extraUnitPrice = extraUnitPrice;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
