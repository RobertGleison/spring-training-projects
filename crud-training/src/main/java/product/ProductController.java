package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok().body(products);
    }
    @GetMapping("/{id}")
    //Improve this in the future
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = service.getProductById(id);
        return ResponseEntity.ok().body(product);
    }
}

