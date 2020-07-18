package am.itspace.imagegallery.repository;

import am.itspace.imagegallery.model.HomeImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<HomeImage,Integer> {
}
