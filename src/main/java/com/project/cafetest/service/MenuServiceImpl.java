package com.project.cafetest.service;

import com.project.cafetest.model.MenuItem;
import com.project.cafetest.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

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
    public List<MenuItem> updateMenuItem(String nama, MenuItem newMenuItem) {
        List<MenuItem> menuItems = menuItemRepository.findByNama(nama);
        menuItems.forEach(menuItem -> {
            if (newMenuItem.getNama() != null && !newMenuItem.getNama().isEmpty()) {
                menuItem.setNama(newMenuItem.getNama());
                menuItem.setCategory(newMenuItem.getCategory());
                menuItem.setHarga(newMenuItem.getHarga());
                menuItem.setShort_desc(newMenuItem.getShort_desc());
                menuItem.setGambar(newMenuItem.getGambar());
                menuItemRepository.save(menuItem);
            } else {
                throw new IllegalArgumentException("New menu item name cannot be null or empty");
            }
        });
        return menuItems;
    }

    @Override
    public List<MenuItem> findByCategory(String category) {
        return menuItemRepository.findByCategory(category);
    }

    @Override
    public List<MenuItem> findByNama(String nama) {
        return menuItemRepository.findByNama(nama);
    }

    @Override
    public void deleteMenuItem(String nama) {
        menuItemRepository.deleteByNama(nama);
    }
}