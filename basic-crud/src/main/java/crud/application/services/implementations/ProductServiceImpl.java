package crud.application.services.implementations;

import crud.application.entities.Product;
import crud.application.repositories.ProductRepository;
import crud.application.exceptions.ResourceNotFoundException;
import crud.application.resources.dtosV1.ProductDtoV1;
import crud.application.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductDtoV1> findAll() {
        return repository.findAll().stream().map(this::convertProductToProductDtoV1).collect(Collectors.toList());
    }

    @Override
    public ProductDtoV1 findById(Integer id) {
        return convertProductToProductDtoV1(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) repository.deleteById(id);
        else throw new ResourceNotFoundException(id);
    }

    @Override
    public Product insert(ProductDtoV1 productDtoV1) {
        Product product = new Product(productDtoV1);
        return repository.save(product);
    }

    @Override
    public ProductDtoV1 update(ProductDtoV1 productDtoV1, Integer id) {
        try {
            Product entity = repository.getReferenceById(id);
            updateData(entity, productDtoV1);
            repository.save(entity);
            return convertProductToProductDtoV1(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product oldProduct, ProductDtoV1 productDtoV1) {
        oldProduct.setName(productDtoV1.name());
        oldProduct.setDescription(productDtoV1.description());
        oldProduct.setPrice(productDtoV1.price());
    }

    public ProductDtoV1 convertProductToProductDtoV1(Product product) {
        return new ProductDtoV1(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
