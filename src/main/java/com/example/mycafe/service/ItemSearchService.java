package com.example.mycafe.service;

import com.example.mycafe.entity.Item;
import com.example.mycafe.repository.ItemSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemSearchService {
    private final ItemSearchRepository itemSearchRepository;
    public Item createItem(Item item) {
        return itemSearchRepository.save(item);
    }

    public List<Item> getItemByName(String keyword) {
        List<Item> byName = itemSearchRepository.findByName(keyword);
        return byName;
    }
}
