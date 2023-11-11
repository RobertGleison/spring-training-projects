package crud.application.services.implementations;

import crud.application.entities.Category;
import crud.application.repositories.CategoryRepository;
import crud.application.exceptions.ResourceNotFoundException;
import crud.application.resources.dtosV1.CategoryDtoV1;
import crud.application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public Category findCategoryById(Integer id){
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Category> findAllCategories(){
        return repository.findAll();
    }

    @Override
    public void deleteCategoryById(Integer id) {

    }

    @Override
    public CategoryDtoV1 update(CategoryDtoV1 categoryDtoV1, Integer id) {
        return null;
    }

    @Override
    public Category insert(CategoryDtoV1 categoryDtoV1) {
        return null;
    }


}
