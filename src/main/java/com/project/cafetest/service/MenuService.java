package com.project.cafetest.service;

import com.project.cafetest.model.MenuItem;

import java.util.List;

public interface MenuService {
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuById(String id);
//    List<MenuItem> updateMenuItem(String id, MenuItem menuItem);
    MenuItem updateMenuItem(String uuid, MenuItem menuItem);
    MenuItem addMenuItem(MenuItem menuItem);
    void deleteMenuItem(String id);
    List<MenuItem> findByCategory(String category);
    List<MenuItem> findByNama(String nama);
}