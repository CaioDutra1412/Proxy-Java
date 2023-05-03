package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarroProxyTest {

    @BeforeEach
    void setUp() {
        BD.addCarro(new Carro(00123456, "Compass", "Jeep", "9BD17164G93988127", 2018, 200));
        BD.addCarro(new Carro(00234567, "CRV", "Honda", "3VWFE21C4YM453726", 2012, 130));
    }

    @Test
    void retornaDadosVeiculo() {
        CarroProxy carro = new CarroProxy(00123456);
        assertEquals(Arrays.asList("Compass", "Jeep", "9BD17164G93988127"), carro.obterDadosVeiculo());
    }

    @Test
    void retornaRenavanAno() {
        Atendente atendente = new Atendente("Caio", true);
        CarroProxy carro = new CarroProxy(00234567);
        assertEquals(Arrays.asList(2012, 130), carro.obterAnoPotencia(atendente));
    }

    @Test
    void retonarExcecaoAtendenteNaoAutorizadoConsultarRenavanAno() {
        try {
            Atendente atendente = new Atendente("Bernardo", false);
            CarroProxy carro = new CarroProxy(00123456);
            carro.obterAnoPotencia(atendente);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Atendente não autorizado", e.getMessage());
        }
    }
}