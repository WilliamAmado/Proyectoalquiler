package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Category;
import com.usa.reto3v2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Category ct){
        categoryService.save(ct);
    //}@PostMapping("/save")
    //public Category saveold(@RequestBody Category ct){
        //return categoryService.save(ct);
    }
}
