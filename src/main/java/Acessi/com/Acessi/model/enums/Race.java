package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Race {
    Amarela("Amarela"),
    Branca("Branca"),
    Indigena("Indígena"),
    Parda("Parda"),
    Preta("Preta"),
    NotDeclared("Não declarada");

    String race;
}
