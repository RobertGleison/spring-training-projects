package crud.application.resources.controllers;

import crud.application.resources.dtosV1.ProductDtoV1;
import crud.application.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerV1 {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping
    public ResponseEntity<List<ProductDtoV1>> findAllProducts(){
        List<ProductDtoV1> products = service.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDtoV1> findProductById(@PathVariable Integer id){
       ProductDtoV1 product = service.findById(id);
       return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProductDtoV1> insertProduct(@RequestBody ProductDtoV1 productDtoV1){
        productDtoV1 = service.insert(productDtoV1);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(productDtoV1.id())
                .toUri();
        return ResponseEntity.created(uri).body(productDtoV1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDtoV1> updateProduct(@PathVariable Integer id, @RequestBody ProductDtoV1 productDtoV1){
        return ResponseEntity.ok().body(service.update(productDtoV1,id));
    }

}
