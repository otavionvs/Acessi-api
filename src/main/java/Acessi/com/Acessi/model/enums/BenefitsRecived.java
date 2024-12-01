package Acessi.com.Acessi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BenefitsRecived {
    BOLSA_FAMILIA("Bolsa Família"),
    AUXILIO_EMERGENCIAL("Auxílio Emergencial"),
    AUXILIO_GAS("Auxílio Gás"),
    APOSENTADORIA("Aposentadoria"),
    PENSAO_POR_MORTE("Pensão por Morte"),
    BPC("Benefício de Prestação Continuada (BPC)"),
    SEGURO_DESEMPREGO("Seguro-Desemprego"),
    AUXILIO_INCLUSAO("Auxílio-Inclusão"),
    ISENCAO_TARIFARIA("Isenção Tarifária de Energia Elétrica"),
    VALE_ALIMENTACAO("Vale-Alimentação"),
    AUXILIO_REABILITACAO_PSICOSSOCIAL("Auxílio Reabilitação Psicossocial"),
    BOLSA_ESCOLA_MUNICIPAL("Bolsa-Escola Municipal"),
    BENEFICIO_SINDICATO("Benefício de Sindicato"),
    BENEFICIO_ONG("Benefício de ONG"),
    BENEFICIO_IGREJA("Benefício da Igreja"),
    PETI("PETI"),
    RENDA_MENSAL_VITALICIA("Renda Mensal Vitalícia"),
    BPC_PESSOA_DEFICIENCIA("BPC-Pessoa com Deficiência"),
    BPC_IDOSO("BPC-Idoso"),
    NENHUM("Nenhum"),
    OUTRO("Outro");

    String benefitsRecived;
}
