package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationLevel {
    Illiterate("Illiterate"),
    ElementarySchool("Elementary School"),
    HighSchool("High School"),
    Graduating("Graduating"),
    Graduate("Graduate"),
    Postgraduate("Postgraduate");

    String educationLevel;
}
