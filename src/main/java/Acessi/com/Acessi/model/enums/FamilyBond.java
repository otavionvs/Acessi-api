package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FamilyBond {
    PAI_MAE("Pai/Mãe"),
    FILHO_FILHA("Filho/Filha"),
    CONJUGE_PARCEIRO("Cônjuge/Parceiro(a)"),
    IRMAO_IRMA("Irmão/Irmã"),
    AVO_AVO("Avô/Avó"),
    NETO_NETA("Neto/Neta"),
    TIO_TIA("Tio/Tia"),
    SOBRINHO_SOBRINHA("Sobrinho/Sobrinha"),
    PRIMO_PRIMA("Primo/Prima"),
    ENTEADO_ENTEADA("Enteado/Enteada"),
    PADRASTO_MADRASTA("Padrasto/Madrasta"),
    GENRO_NORA("Genro/Nora"),
    SOGRO_SOGRA("Sogro/Sogra"),
    CUNHADO_CUNHADA("Cunhado/Cunhada"),
    BISAVO_BISAVO("Bisavô/Bisavó"),
    BISNETO_BISNETA("Bisneto/Bisneta"),
    AMIGO_PROXIMO("Amigo(a) Próximo(a)"),
    TUTOR_LEGAL("Tutor(a) Legal"),
    GUARDA_RESPONSAVEL("Guarda/Responsável"),
    OUTRO("Outro");

    String familyBond;
}
