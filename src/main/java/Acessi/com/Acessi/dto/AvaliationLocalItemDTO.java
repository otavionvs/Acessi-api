package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import lombok.Getter;

@Getter
public class AvaliationLocalItemDTO {

    private Integer idLocalItemAvaliation;
    private Integer idLocalAvaliation;
    private String avaliationGivenByUser;
    private Float avaliationRating;
    private String idUser;
}
