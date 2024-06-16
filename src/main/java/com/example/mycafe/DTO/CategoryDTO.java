package com.example.mycafe.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long idx;
    private String categoryName;

    @Builder
    public CategoryDTO (Long idx, String categoryName) {
        this.idx = idx;
        this.categoryName = categoryName;
    }
}