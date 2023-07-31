package com.HandTerminal.HotCatCafe.DTOs;

import java.util.ArrayList;
import java.util.List;



public class CategoryDTO extends BaseEntity {
    

    private String categoryName;

    private List<ExtraDTO> extraDtoList;

    public CategoryDTO() {
        extraDtoList = new ArrayList<>();
    }
    
    public String getCategoryName() {
        return categoryName;
    }
   
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ExtraDTO> getExtraDtoList() {
        return extraDtoList;
    }

    public void setExtraDtoList(List<ExtraDTO> extraDtoList) {
        this.extraDtoList = extraDtoList;
    }
}
