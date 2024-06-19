package com.example.mycafe.controller;

import com.example.mycafe.base.DTO.CategoryDTO;
import com.example.mycafe.base.DTO.DataResponseDTO;
import com.example.mycafe.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }

    @GetMapping("api/category/list")
    public List<CategoryDTO> getCategoryList() {
        List<CategoryDTO> list = categoryService.getCategoryList();
        return list;
    }

    @PostMapping("api/category/create")
    public DataResponseDTO<CategoryDTO> postCategoryCreate(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.postCategoryCreate(categoryDTO);
    }
}
