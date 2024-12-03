package Acessi.com.Acessi.model.enums;

public enum FormTypeDeficiency {
    PARAPLEGIA_PARAPARESIA("Paraplegia/Paraparesia"),
    TETRAPLEGIA_TETRAPARESIA("Tetraplegia/Tetraparesia"),
    MONOPLEGIA_MONOPARESIA("Monoplegia/Monoparesia"),
    HEMIPLEGIA_HEMIPARESIA("Hemiplegia/Hemiparesia"),
    AMPUTACAO_AUSENCIA("Amputação/Ausência de Membros"),
    PARALISIA_CEREBRAL("Paralisia Cerebral"),
    NANISMO("Nanismo"),
    OSTOMIA("Ostomia"),
    DEFORMIDADES_CORPO("Deformidades no Corpo"),
    AUTISMO("Autismo"),
    PSICOSE_INFANTIL("Psicose Infantil"),
    SINDROME_KANNER("Síndrome de Kanner"),
    SINDROME_RETT("Síndrome de Rett"),
    SINDROME_ASPERGER("Síndrome de Asperger");

    private final String label;

    FormTypeDeficiency(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
