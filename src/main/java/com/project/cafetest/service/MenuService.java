package com.project.cafetest.service;
import com.project.cafetest.model.MenuItem;

import java.util.List;


public interface MenuService {
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuById(String id);
    MenuItem updateMenuItem(String id, MenuItem menuItem);

    MenuItem addMenuItem(MenuItem menuItem);

    void deleteMenuItem(String id);
}
