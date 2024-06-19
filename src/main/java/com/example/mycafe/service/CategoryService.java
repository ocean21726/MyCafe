package com.example.mycafe.service;

import com.example.mycafe.base.DTO.CategoryDTO;
import com.example.mycafe.base.DTO.DataResponseDTO;
import com.example.mycafe.base.DTO.ErrorResponseDTO;
import com.example.mycafe.base.GeneralException;
import com.example.mycafe.base.constant.Code;
import com.example.mycafe.entity.Category;
import com.example.mycafe.repository.CategoryRepository;
import org.springframework.dao.DuplicateKeyException;
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

    public DataResponseDTO<CategoryDTO> postCategoryCreate(CategoryDTO categoryDTO) {
        Optional<Category> findCategory = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (findCategory.isEmpty()) {
            Category category = Category.builder()
                    .categoryName(categoryDTO.getCategoryName())
                    .build();
            categoryRepository.save(category);
            CategoryDTO newCategory = CategoryDTO.builder()
                    .idx(category.getIdx())
                    .categoryName(category.getCategoryName())
                    .build();
            return DataResponseDTO.of(newCategory);
        } else {
            throw new GeneralException(Code.VALIDATION_ERROR, "이미 존재하는 이름입니다.");
        }
    }

    public boolean isUsableCategory(Long idx) {
        Optional<Category> category = categoryRepository.findById(idx);
        if (category.isEmpty()) { return false; }
        else return true;
    }
}
