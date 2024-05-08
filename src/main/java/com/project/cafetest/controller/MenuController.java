package com.project.cafetest.controller;


import com.project.cafetest.model.MenuItem;
import com.project.cafetest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/get")
    public List<MenuItem> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    @GetMapping("/get/{id}")
    public MenuItem getMenuById(@PathVariable String id) {
        return menuService.getMenuById(id);
    }

    @PostMapping("/modify")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuService.addMenuItem(menuItem);
    }

    @PutMapping("/modify/{id}")
    public MenuItem updateMenuItem(@PathVariable String id, @RequestBody MenuItem menuItem) {
        return menuService.updateMenuItem(id, menuItem);
    }

    @DeleteMapping("/modify/{id}")
    public void deleteMenuItem(@PathVariable String id) {
        menuService.deleteMenuItem(id);
    }
}
