package am.itspace.imagegallery.controller;

import am.itspace.imagegallery.model.Category;
import am.itspace.imagegallery.model.HomeImage;
import am.itspace.imagegallery.model.Image;
;
import am.itspace.imagegallery.service.CategoryService;
import am.itspace.imagegallery.service.HomeImageService;
import am.itspace.imagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.io.File;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    @Value("${file.upload.dir}")
    private String uploadDir;

    private final CategoryService categoryService;
    private final ImageService imageService;
    private final HomeImageService homeImageService;

    @PostMapping("/saveHomeImage" )
    public String saveHomeImage(@ModelAttribute HomeImage home, @RequestParam("image") MultipartFile file) throws IOException   {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File img = new File(uploadDir, name);
        file.transferTo(img);
        home.setPicUrl(name);
        homeImageService.save(home);
        return "redirect:admin";
    }

    @PostMapping("/saveCategory" )
    public String saveCategory(@ModelAttribute Category category,@RequestParam("image") MultipartFile file) throws IOException   {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File img = new File(uploadDir, name);
        file.transferTo(img);
        category.setPicUrl(name);
        categoryService.save(category);
        return "redirect:admin";
    }

    @GetMapping("/admin")
    public String authorPage(@AuthenticationPrincipal Principal principal, ModelMap modelMap) {
        String username = null;
        if (principal != null) {
            username = principal.getName();
        }
        List<Category> allCategory = categoryService.categoryFindAll();
        modelMap.addAttribute("categories", allCategory);
        modelMap.addAttribute("username", username);
        return "admin";
    }
    @GetMapping("/allHomeImages")
    public String allHomeImagesPage(ModelMap modelMap) {
        List<HomeImage> allHomeImages = homeImageService.findAll();
        modelMap.addAttribute("homeImages", allHomeImages);
        return "allHomeImages";
    }

    @PostMapping("/saveImage")
    public String saveImage(@ModelAttribute Image img1 ,@RequestParam("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File img = new File(uploadDir, name);
        file.transferTo(img);
        img1.setPicUrl(name);
        imageService.save(img1);
        return "redirect:/admin";
    }


    @GetMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody
    byte[] getImage(@RequestParam("name") String imageName) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
        return IOUtils.toByteArray(in);
    }
}
