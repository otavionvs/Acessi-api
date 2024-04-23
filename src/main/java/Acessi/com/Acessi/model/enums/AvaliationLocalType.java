package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AvaliationLocalType {

    Restaurant("Restaurant"),
    Pub("Pub"),
    Park("Park"),
    Public("Public"),
    Private("Private"),
    Another("Another");

    String description;

}
