package am.itspace.imagegallery.service;

import am.itspace.imagegallery.model.Category;
import am.itspace.imagegallery.repository.CategoryRepository;
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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;


    public void save(Category category){
        categoryRepository.save(category);
    }
    public List<Category> categoryFindAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findeById(int id){
        return categoryRepository.findById(id);

    }


}
