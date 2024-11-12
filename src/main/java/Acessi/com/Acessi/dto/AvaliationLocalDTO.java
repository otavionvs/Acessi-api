package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.entity.AvaliationLocalItem;
import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class AvaliationLocalDTO {

    private Integer idLocalAvaliation;
    private String name;
    private String imageAvaliationLocal;
    private AvaliationLocalType typeLocalAvaliation;
    private Float avaliationRating;
}
