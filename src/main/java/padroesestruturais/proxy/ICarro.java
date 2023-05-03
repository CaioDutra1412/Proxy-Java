package padroesestruturais.proxy;

import java.util.List;

public interface ICarro {
    List<String> obterDadosVeiculo();
    List<Integer> obterAnoPotencia(Atendente atendente);
}
