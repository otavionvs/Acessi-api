package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PrimaryCaregiver {
    PAI("Pai"),
    MAE("Mãe"),
    AVO_AVO("Avô/Avó"),
    IRMAO_IRMA("Irmão/Irmã"),
    TIO_TIA("Tio/Tia"),
    CONJUGE_PARCEIRO("Cônjuge/Parceiro(a)"),
    AMIGO("Amigo(a)"),
    VIZINHO("Vizinho(a)"),
    CUIDADOR_PROFISSIONAL("Cuidador Profissional"),
    OUTRO("Outro");

    String primaryCaregiver;
}
