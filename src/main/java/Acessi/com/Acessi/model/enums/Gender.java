package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    Masculine("Masculine"), //0
    Feminine("Feminine"), //1
    Other("Other"); //2

    String gender;
}
