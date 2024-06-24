package Acessi.com.Acessi.model.entity;

import Acessi.com.Acessi.model.enums.StatusNews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idNews;
    @Column(nullable = false, length = 150)
    private String titleNews;
    @Column(nullable = false)
    private String descriptionNews;
    @Column(nullable = false)
    private String publicationDateNews;
    @Column(nullable = false)
    private StatusNews statusNews;
    @Column
    private String tagsNews;


}
