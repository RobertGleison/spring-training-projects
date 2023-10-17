package crud.application.services;

import crud.application.entities.Product;
import crud.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Product insert(Product product){
        return repository.save(product);
    }

    public Product update(Integer id, Product product){
        Product entity = repository.getReferenceById(id);
        updateData(entity, product);
        return repository.save(entity);
    }

    private void updateData(Product oldProduct, Product newProduct){
        oldProduct.setName(newProduct.getName());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setPrice(newProduct.getPrice());
    }
}
