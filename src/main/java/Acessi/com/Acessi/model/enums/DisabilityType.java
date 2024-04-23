package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DisabilityType {
    VISUAL("Deficiência Visual"),
    AUDITIVA("Deficiência Auditiva"),
    MOTORA("Deficiência Motora"),
    INTELECTUAL("Deficiência Intelectual"),
    AUTISMO("Espectro Autista"),
    FISICA("Deficiência Física"),
    COGNITIVA("Deficiência Cognitiva"),
    OUTRA("Outra");

    String descricao;
}
