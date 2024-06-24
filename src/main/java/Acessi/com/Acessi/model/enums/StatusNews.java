package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusNews {
    User("Public"), //0
    Company("Private"), //1
    Admin("Listed"); //2

    String statusNews;
}
