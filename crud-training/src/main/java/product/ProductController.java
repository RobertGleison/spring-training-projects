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
    ProductService service;

    @GetMapping("/{id}")
    //Improve this in the future
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer id) {
        Optional<Product> product = service.getProductById(id);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    //Fiz this variable id
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        service.deleteProductById(id);

    }
}

