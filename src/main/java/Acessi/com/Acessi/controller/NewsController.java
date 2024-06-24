package Acessi.com.Acessi.controller;

import Acessi.com.Acessi.dto.NewsDTO;
import Acessi.com.Acessi.dto.UserDTO;
import Acessi.com.Acessi.model.entity.News;
import Acessi.com.Acessi.model.entity.User;
import Acessi.com.Acessi.model.enums.AccessLevel;
import Acessi.com.Acessi.model.service.NewsService;
import Acessi.com.Acessi.model.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable Integer id) {
        Optional<News> news = newsService.findById(id);

        if (news.isPresent()) {
            return ResponseEntity.ok(news.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid NewsDTO newsDTO) {
        News news = new News();
        BeanUtils.copyProperties(newsDTO, news);
        return ResponseEntity.status(HttpStatus.OK).body(newsService.save(news));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteById(@PathVariable Integer id) {
//
//    }

}
