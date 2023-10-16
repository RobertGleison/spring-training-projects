package crud.controllers;

import crud.entities.Product;
import crud.repositories.ProductRepository;
import crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = service.findAll();
        return ResponseEntity.ok().build();
    }
}
