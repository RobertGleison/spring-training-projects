package crud.application.controllers;

import crud.application.entities.Category;
import crud.application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories(){
        return ResponseEntity.ok().body(service.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id){
        Category category = service.findCategoryById(id);
        return ResponseEntity.ok().body(category);
    }
}
