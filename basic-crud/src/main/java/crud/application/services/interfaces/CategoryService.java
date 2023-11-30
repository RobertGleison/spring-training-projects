package crud.application.services.interfaces;

import crud.application.entities.Category;
import crud.application.resources.dtosV1.CategoryDtoV1;

import java.util.List;

public interface CategoryService {
    CategoryDtoV1 findCategoryById(Integer id);
    List<CategoryDtoV1> findAllCategories();
    void deleteCategoryById(Integer id);
    CategoryDtoV1 update(CategoryDtoV1 categoryDtoV1, Integer id);
    CategoryDtoV1 insert(CategoryDtoV1 categoryDtoV1);
}
