package com.example.mycafe.controller;

import com.example.mycafe.DTO.MenuDTO;
import com.example.mycafe.entity.Menu;
import com.example.mycafe.entity.User;
import com.example.mycafe.repository.MenuRepository;
import com.example.mycafe.repository.UserRepository;
import com.example.mycafe.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
//    private final MenuRepository menuRepository;
    private final MenuService menuService;

    MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

//    @GetMapping("/api/menu/list")
//    List<Menu> all() {
//        return menuRepository.findAll();
//    }

    @PostMapping("api/menu/create")
    public void create(@RequestBody MenuDTO menuDTO) {
        menuService.createMenu(menuDTO);
    }
}
