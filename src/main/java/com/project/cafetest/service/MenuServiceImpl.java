package com.project.cafetest.service;


import com.project.cafetest.model.MenuItem;
import com.project.cafetest.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService{


    @Autowired
    private MenuRepo menuItemRepository;

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuById(String id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(String id, MenuItem menuItem) {
        if (menuItemRepository.existsById(id)) {
            menuItem.setId(id);
            return menuItemRepository.save(menuItem);
        }
        return null;
    }

    @Override
    public void deleteMenuItem(String id) {
        menuItemRepository.deleteById(id);
    }
}
