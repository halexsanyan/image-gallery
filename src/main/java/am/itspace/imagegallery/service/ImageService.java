package am.itspace.imagegallery.service;

import am.itspace.imagegallery.model.Image;
import am.itspace.imagegallery.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
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
