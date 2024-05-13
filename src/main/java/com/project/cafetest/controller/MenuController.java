package com.project.cafetest.controller;



import com.project.cafetest.model.MenuItem;
import com.project.cafetest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/get")
    public List<MenuItem> getAllMenuItems()  {
        return menuService.getAllMenuItems();
    }
    // localhost:8080/api/menu/get

    @GetMapping("/get/{id}")
    public MenuItem getMenuById(@PathVariable String id) {
        return menuService.getMenuById(id);
    }
    // localhost:8080/api/menu/get/{id}

    @PostMapping("/modify")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuService.addMenuItem(menuItem);
    }
    // localhost:8080/api/menu/modify

    @PutMapping("/modify/{nama}")
    public List<MenuItem> updateMenuItem(@PathVariable String nama, @RequestBody MenuItem menuItem) {
        return menuService.updateMenuItem(nama, menuItem);
    }
    // localhost:8080/api/menu/modify/{nama}

    @GetMapping("/getnama")
    public List<MenuItem> findByNama(@RequestParam String nama) {
        return menuService.findByNama(nama);
    }
    //localhost:8080/api/menu/getnama?nama={nama}

    @GetMapping("/getcategory")
    public List<MenuItem> findByCategory(@RequestParam String category) {
        return menuService.findByCategory(category);
    }
    //localhost:8080/api/menu/getcategory?category={category}

    @DeleteMapping("/modify/{nama}")
    public void deleteMenuItem(@PathVariable String nama) {
        menuService.deleteMenuItem(nama);
    }
    // localhost:8080/api/menu/modify/{nama}

}
