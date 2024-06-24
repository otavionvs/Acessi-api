package Acessi.com.Acessi.model.service;

import Acessi.com.Acessi.model.entity.News;
import Acessi.com.Acessi.repository.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsService {
    private NewsRepository newsRepository;

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public News save(News entity) {
        return newsRepository.save(entity);
    }

    public Optional<News> findById(Integer integer) {
        return newsRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return newsRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        newsRepository.deleteById(integer);
    }
}
