package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccessLevel {
    User("User"), //0
    Company("Company"), //1
    Admin("Admin"); //2

    String accessLevel;
}
