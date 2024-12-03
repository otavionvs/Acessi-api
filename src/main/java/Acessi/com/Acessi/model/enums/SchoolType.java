package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SchoolType {
    ESCOLA_PUBLICA("Escola pública"),
    ESCOLA_PRIVADA("Escola privada"),
    ESCOLA_COMUNITARIA("Escola comunitária"),
    ESCOLA_FILANTROPICA("Escola filantrópica"),
    CLASSE_REGULAR("Classe regular"),
    CLASSE_ESPECIAL("Classe especial"),
    EJA("EJA (Educação de Jovens e Adultos)"),
    OUTRO("Outro");

    String schoolType;
}
