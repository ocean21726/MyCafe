package com.example.mycafe.base.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class MenuDTO {
    private Long categoryIdx;
    private String menuName;
    private String comment;

    @Builder
    public MenuDTO (Long categoryIdx, String menuName, String comment) {
        this.categoryIdx = categoryIdx;
        this.menuName = menuName;
        this.comment = comment;
    }
}
