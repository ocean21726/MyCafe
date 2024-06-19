package com.example.mycafe.controller;

import com.example.mycafe.base.DTO.DataResponseDTO;
import com.example.mycafe.entity.Item;
import com.example.mycafe.service.ItemSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item/search")
public class ItemSearchController {
    private final ItemSearchService itemSearchService;

    @GetMapping
    public DataResponseDTO<List<Item>> search(@RequestParam("keyword") String keyword) {
        return DataResponseDTO.of(itemSearchService.getItemByName(keyword));
    }

    @PostMapping
    public DataResponseDTO<Item> create(@RequestBody Item item) {
        return DataResponseDTO.of(itemSearchService.createItem(item));
    }
}
