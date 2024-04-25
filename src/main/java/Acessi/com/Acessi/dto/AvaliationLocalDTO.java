package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.awt.*;
@Getter
public class AvaliationLocalDTO {

    private Integer idLocalAvaliation;
    private String name;
    private byte[] imageAvaliationLocal;
    private AvaliationLocalType typeLocalAvaliation;
}
