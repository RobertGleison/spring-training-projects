package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Optional<Product> getProductById(Integer id) {
        //IMplement Exception handler
        Optional<Product> product = repository.findById(id);
        return repository.findById(id);
    }

    public List<Product> getAllProducts() {
        List<Product> products = repository.findAll();
        return products;
    }

    public void deleteProductById(Integer id) {
        repository.deleteById(id);
    }
}
