package crud.application.services;

import crud.application.entities.Category;
import crud.application.repositories.CategoryRepository;
import crud.application.exceptions.ResourceNotFoundException;
import crud.application.resources.dtosV1.CategoryDtoV1;
import crud.application.services.interfaces.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public CategoryDtoV1 findCategoryById(Integer id) {
        Optional<Category> category = repository.findById(id);
        return convertCategoryToCategoryDtoV1(category.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<CategoryDtoV1> findAllCategories() {
        return repository.findAll().stream().map(this::convertCategoryToCategoryDtoV1).collect(Collectors.toList());
    }

    @Override
    public void deleteCategoryById(Integer id) {
        Optional<Category> category = repository.findById(id);
        if (category.isPresent()) repository.deleteById(id);
        else throw new ResourceNotFoundException(id);
    }

    @Override
    public CategoryDtoV1 update(CategoryDtoV1 categoryDtoV1, Integer id) {
        try {
            Category category = repository.getReferenceById(id);
            updateData(categoryDtoV1, category);
            return convertCategoryToCategoryDtoV1(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    public CategoryDtoV1 insert(CategoryDtoV1 categoryDtoV1) {
        Category category = new Category(categoryDtoV1);
        return convertCategoryToCategoryDtoV1(repository.save(category));
    }

    private CategoryDtoV1 convertCategoryToCategoryDtoV1(Category category) {
        return new CategoryDtoV1(
                category.getId(),
                category.getName()
        );
    }

    private void updateData(CategoryDtoV1 categoryDtoV1, Category category) {
        category.setId(categoryDtoV1.id());
        category.setName(categoryDtoV1.name());
    }
}
