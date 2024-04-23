package Acessi.com.Acessi.dto;

import Acessi.com.Acessi.model.enums.AvaliationLocalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.awt.*;
@Getter
public class AvaliationLocalDTO {

    @NotBlank
    private Integer idLocalAvaliation;
    @NotBlank
    private String name;
    @NotBlank
    private Image imageAvaliationLocal;
    @NotNull
    private AvaliationLocalType typeLocalAvaliation;
}
