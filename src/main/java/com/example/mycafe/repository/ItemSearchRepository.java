package com.example.mycafe.repository;

import com.example.mycafe.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemSearchRepository extends ElasticsearchRepository<Item, Long> {
    List<Item> findByName(String keyword);
}
