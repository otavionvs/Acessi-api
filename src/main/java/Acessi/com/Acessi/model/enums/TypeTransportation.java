package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeTransportation {
    TRANSPORTE_ESCOLAR_PUBLICO("Transporte escolar público"),
    TRANSPORTE_ESCOLAR_PRIVADO("Transporte escolar privado"),
    TRANSPORTE_FAMILIAR("Transporte familiar"),
    TRANSPORTE_COLETIVO_URBANO("Transporte coletivo urbano"),
    OUTRO("Outro");

    String typeTransportation;
}
