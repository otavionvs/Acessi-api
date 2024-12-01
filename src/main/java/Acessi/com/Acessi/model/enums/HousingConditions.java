package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HousingConditions {
    CASA_PROPRIA("Casa própria"),
    CASA_ALUGADA("Casa alugada"),
    CASA_CEDIDA("Casa cedida"),
    CASA_FINANCIADA("Casa financiada"),
    BARRACO("Barraco"),
    OCUPACAO_IRREGULAR("Ocupação irregular"),
    ALOJAMENTO_COLETIVO("Alojamento coletivo"),
    SITUACAO_RUA("Em situação de rua"),
    OUTRO("Outro");

    String housingConditions;
}
