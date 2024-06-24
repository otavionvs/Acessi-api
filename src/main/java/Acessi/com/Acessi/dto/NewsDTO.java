package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.enums.StatusNews;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class NewsDTO {
    @NotBlank
    private String titleNews;
    @NotBlank
    private String descriptionNews;
    @NotBlank
    private String publicationDateNews;
    @NotNull
    private StatusNews statusNews;
    private String tagsNews;
}
