package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    Masculino("Masculino"), //0
    Feminino("Feminino"), //1
    Outro("Outro"); //2

//    Masculine("Masculine"), //0
//    Feminine("Feminine"), //1
//    Other("Other"); //2

    String gender;
}
