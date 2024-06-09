package com.example.mycafe.service;

import com.example.mycafe.DTO.MenuDTO;
import com.example.mycafe.entity.Menu;
import com.example.mycafe.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService (MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void createMenu (MenuDTO menuDTO) {
        Menu menu = new Menu(
                menuDTO.getCategoryIdx(),
                menuDTO.getMenuName(),
                menuDTO.getComment()
        );
        menuRepository.save(menu);
    }
}
