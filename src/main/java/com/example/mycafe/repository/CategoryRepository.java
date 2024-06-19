package com.example.mycafe.repository;

import com.example.mycafe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUseYNTrue();
    Optional<Category> findByCategoryName(String categoryName);
}
