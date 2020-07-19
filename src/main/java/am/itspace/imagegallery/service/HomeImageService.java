package am.itspace.imagegallery.service;

import am.itspace.imagegallery.model.HomeImage;
import am.itspace.imagegallery.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeImageService {
    private final HomeRepository homeRepository;

    public void save(HomeImage homeImahe) {
       homeRepository.save(homeImahe);
    }
    public List<HomeImage> findAll() {
        return homeRepository.findAll();
    }
    public Optional<HomeImage> findeById(int id) {
        return homeRepository.findById(id);
    }
}
