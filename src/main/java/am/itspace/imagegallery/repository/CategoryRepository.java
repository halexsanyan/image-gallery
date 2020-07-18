package am.itspace.imagegallery.repository;

import am.itspace.imagegallery.model.Category;
import am.itspace.imagegallery.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
