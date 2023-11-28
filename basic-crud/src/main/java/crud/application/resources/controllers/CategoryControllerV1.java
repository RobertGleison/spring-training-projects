package crud.application.resources.controllers;

import crud.application.entities.Category;
import crud.application.resources.dtosV1.CategoryDtoV1;
import crud.application.services.implementations.CategoryServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<CategoryDtoV1> insertCategory(@RequestBody CategoryDtoV1 categoryDtoV1){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(categoryDtoV1.id()).toUri();
        return ResponseEntity.created(uri).body(service.insert(categoryDtoV1));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDtoV1> updateCategory(@RequestBody CategoryDtoV1 categoryDtoV1, @PathVariable Integer id){
        return ResponseEntity.ok().body(service.update(categoryDtoV1, id));
    }

}
