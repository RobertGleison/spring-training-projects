package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        var products = service.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Product product = service.findProductById(id);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

    }


}
