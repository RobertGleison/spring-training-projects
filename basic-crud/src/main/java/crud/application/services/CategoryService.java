package crud.application.services;

import crud.application.entities.Category;
import java.util.List;

public interface CategoryService {
    Category findCategoryById(Integer id);
    List<Category> findAllCategories();
}
