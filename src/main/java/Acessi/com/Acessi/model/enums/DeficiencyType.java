package Acessi.com.Acessi.model.enums;

import java.util.Arrays;
import java.util.List;

public enum DeficiencyType {
    DEFICIENCIA_MULTIPLA("Deficiência Múltipla", List.of()),
    CEGUEIRA("Cegueira", List.of()),
    BAIXA_VISAO("Baixa Visão", List.of()),
    SURDEZ("Surdez", List.of()),
    DEFICIENCIA_AUDITIVA("Deficiência Auditiva", List.of()),
    SURDOCEGUEIRA("Surdocegueira", List.of()),
    DEFICIENCIA_FISICA("Deficiência Física", Arrays.asList(
            FormTypeDeficiency.PARAPLEGIA_PARAPARESIA,
            FormTypeDeficiency.TETRAPLEGIA_TETRAPARESIA,
            FormTypeDeficiency.MONOPLEGIA_MONOPARESIA,
            FormTypeDeficiency.HEMIPLEGIA_HEMIPARESIA,
            FormTypeDeficiency.AMPUTACAO_AUSENCIA,
            FormTypeDeficiency.PARALISIA_CEREBRAL,
            FormTypeDeficiency.NANISMO,
            FormTypeDeficiency.OSTOMIA,
            FormTypeDeficiency.DEFORMIDADES_CORPO
    )),
    DEFICIENCIA_MENTAL("Deficiência Mental/Intelectual", List.of()),
    TRANSTORNOS_DESENVOLVIMENTO("Transtornos Globais do Desenvolvimento", Arrays.asList(
            FormTypeDeficiency.AUTISMO,
            FormTypeDeficiency.PSICOSE_INFANTIL,
            FormTypeDeficiency.SINDROME_KANNER,
            FormTypeDeficiency.SINDROME_RETT,
            FormTypeDeficiency.SINDROME_ASPERGER
    )),
    SINDROME_DOWN("Síndrome de Down", List.of()),
    DOENCAS_CRONICAS("Doenças Crônicas/Degenerativas", List.of());

    private final String label;
    private final List<FormTypeDeficiency> forms;

    DeficiencyType(String label, List<FormTypeDeficiency> forms) {
        this.label = label;
        this.forms = forms;
    }

    public String getLabel() {
        return label;
    }

    public List<FormTypeDeficiency> getForms() {
        return forms;
    }
}
