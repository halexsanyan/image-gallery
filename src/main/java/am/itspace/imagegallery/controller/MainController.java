package am.itspace.imagegallery.controller;

import am.itspace.imagegallery.model.Category;
import am.itspace.imagegallery.model.HomeImage;
import am.itspace.imagegallery.service.CategoryService;
import am.itspace.imagegallery.service.HomeImageService;
import am.itspace.imagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CategoryService categoryService;
    private final ImageService imageService;
    private final HomeImageService homeImageService;
    private int id = 1;

    @GetMapping("/")
    public String homePage(@RequestParam(name = "id", required = false) Integer newId, ModelMap modelMap) {
        if (newId != null && newId != 0){
            this.id=newId;
            return "admin";
        }
            List<Category> all = categoryService.categoryFindAll();
        Optional<HomeImage> one = homeImageService.findeById(this.id);
        if (!one.isPresent()) {
            return "redirect:/";
        }

        modelMap.addAttribute("categories", all);
        modelMap.addAttribute("himeImage", one.get());

        return "index";
    }


    @GetMapping("/{id}")
    public String categoryImg(@PathVariable(value = "id") int id, ModelMap modelMap) {
        Optional<Category> one = categoryService.findeById(id);
        if (!one.isPresent()) {
            return "redirect:/";
        }
        modelMap.addAttribute("category", one.get());
        modelMap.addAttribute("images", imageService.imageFindByCategoryId(id));
        return "categoryImages";
    }

}
