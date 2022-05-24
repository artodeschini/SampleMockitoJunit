package org.todeschini;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @AfterEach
    void tearDown() {
        calculadora = null;
    }

    @Test
    void deveSomar() {
        //given
        int n1 = 10, n2 = 5, resultado;

        //when
        resultado = calculadora.somar(n1, n2);

        //then
        assertThat(resultado).isEqualTo(15);
    }

    @Test
    void naoDeveSomarNumerosNegativos() {
        //given
        int n1 = 10, n2 = -5, resultado;

        //when // then
        //assertThat(calculadora.somar(n1, n2)).th;
        assertThatThrownBy(() -> {
            calculadora.somar(n1, n2);
        }).isInstanceOf(RuntimeException.class).hasMessage("nao deve somar numeros negativos").hasMessageContaining("negativos");
    }

    @Test
    void naoDeveSomarNumerosNegativosOutro() {
        //given
        int n1 = 10, n2 = -5, resultado;

        //when // then
        //assertThat(calculadora.somar(n1, n2)).th;
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            calculadora.somar(n1, n2);
        }).withMessageContaining("negativos");
    }

    @Test
    void deveSubtrair() {
        //given
        int n1 = 10, n2 = 5, resultado;

        //when
        resultado = calculadora.subtrair(n1, n2);

        //then
        assertThat(resultado).isEqualTo(5);
    }

    @Test
    void deveMultiplicar() {
        //given
        int n1 = 10, n2 = 5, resultado;

        //when
        resultado = calculadora.multiplicar(n1, n2);

        //then
        assertThat(resultado).isEqualTo(50);
    }

    @Test
    void deveDividir() {
        //given
        int n1 = 10, n2 = 5, resultado;

        //when
        resultado = calculadora.dividir(n1, n2);

        //then
        assertThat(resultado).isEqualTo(2);
    }

    @Test
    void naoDeveDividirPorZero() {
        //given
        int n1 = 10, n2 = 0;

        //when // then
        assertThatThrownBy(() -> {
            calculadora.dividir(n1, n2);
        }).isInstanceOf(RuntimeException.class).hasMessage("divisao nao pode ser por zero").hasMessageContaining("zero");
    }

}