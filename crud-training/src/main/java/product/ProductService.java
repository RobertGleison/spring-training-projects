package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product getProductById(Integer id) {
        //Implement Exception handler
        Optional<Product> product = repository.findById(id);
        //Implement a more safe way instead of .get(), like orElseThrow
        return product.get();
    }

    public List<Product> getAllProducts() {
        return repository.findAll();

    }
}
