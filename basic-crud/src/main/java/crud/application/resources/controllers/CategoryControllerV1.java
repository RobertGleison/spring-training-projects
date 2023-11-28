package crud.application.resources.controllers;

import crud.application.entities.Category;
import crud.application.resources.dtosV1.CategoryDtoV1;
import crud.application.services.implementations.CategoryServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryControllerV1 {

    @Autowired
    private CategoryServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CategoryDtoV1>> findAllCategories(){
        return ResponseEntity.ok().body(service.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDtoV1> findCategoryById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findCategoryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        service.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping

}
