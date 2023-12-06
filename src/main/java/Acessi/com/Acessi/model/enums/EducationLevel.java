package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationLevel {
    Analfabeto("Analfabeto"),
    EnsinoFundamental("Ensino Fundamental"),
    EnsinoMedio("Ensino Médio"),
    Graduando("Graduando"),
    Graduado("Graduado"),
    PosGraduado("Pós-Graduado");

//    Illiterate("Illiterate"),
//    ElementarySchool("Elementary School"),
//    HighSchool("High School"),
//    Graduating("Graduating"),
//    Graduate("Graduate"),
//    Postgraduate("Postgraduate");

    String educationLevel;
}
