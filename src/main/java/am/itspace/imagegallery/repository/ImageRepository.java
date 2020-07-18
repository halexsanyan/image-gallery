package am.itspace.imagegallery.repository;

import am.itspace.imagegallery.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Integer> {
   List<Image> findByCategoryId(int id);
}
