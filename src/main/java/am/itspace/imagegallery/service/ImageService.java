package am.itspace.imagegallery.service;

import am.itspace.imagegallery.model.Image;
import am.itspace.imagegallery.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {


    private final ImageRepository imageRepository;

    public void save(Image image) {

        imageRepository.save(image);
    }


    public List<Image> imageFindByCategoryId(int id) {

        return imageRepository.findByCategoryId(id);
    }

}
