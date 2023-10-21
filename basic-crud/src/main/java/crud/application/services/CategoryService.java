package crud.application.services;

import crud.application.entities.Category;
import crud.application.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;


    public Category findById(Integer id){
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow()
    }
}
