package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.entity.AvaliationLocal;
import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class AvaliationLocalItemDTO {

    private Integer idLocalItemAvaliation;
    private AvaliationLocal avaliationLocal;
    private String avaliationGivenByUser;
    private Float avaliationRating;
    private String idUser;
    private LocalDateTime dateAvaliation;
}
