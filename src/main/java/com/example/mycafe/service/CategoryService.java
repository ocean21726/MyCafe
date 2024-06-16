package com.example.mycafe.service;

import com.example.mycafe.DTO.CategoryDTO;
import com.example.mycafe.entity.Category;
import com.example.mycafe.entity.Menu;
import com.example.mycafe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    CategoryService (CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    public List<CategoryDTO> getCategoryList() {
        List<Category> categoryList = categoryRepository.findByUseYNTrue();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO dto = new CategoryDTO(
                    category.getIdx(),
                    category.getCategoryName()
            );

            categoryDTOList.add(dto);
        }
        return categoryDTOList;
    }

    public CategoryDTO postCategoryCreate(CategoryDTO categoryDTO) {
        
        Category category = new Category(
                categoryDTO.getCategoryName()
        );
        categoryRepository.save(category);

        CategoryDTO newCategoryDTO = new CategoryDTO(
                category.getIdx(),
                category.getCategoryName()
        );
        return newCategoryDTO;
    }
}
