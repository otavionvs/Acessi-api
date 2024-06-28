package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationLevel {
    Analfabeto("Analfabeto"),
    EnsinoFundamental("Ensino Fundamental"),
    EnsinoMedio("Ensino Médio"),
    EnsinoSuperior("Ensino Superior"),
    PosGraduacao("Pós-Graduação");

//    Illiterate("Illiterate"),
//    ElementarySchool("Elementary School"),
//    HighSchool("High School"),
//    Graduating("Graduating"),
//    Graduate("Graduate"),
//    Postgraduate("Postgraduate");

    String educationLevel;
}
