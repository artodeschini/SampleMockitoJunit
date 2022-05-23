package org.todeschini;

import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;
import static  org.assertj.core.api.Assertions.*;

public class SampleAssertJ {

    @Test
    public void sampleAssertJ() {
        //given
        int numero1 = 10, numero2= 5, resultado = 0;

        //when
        resultado = numero1 + numero2;

        //then
        //assert for junit 5
        org.junit.jupiter.api.Assertions.assertEquals(resultado, 15);

        //assert for assertj samples

        //se resultadi está entre o interval de 14 a 16
        assertThat(resultado).isBetween(14, 16);
        //se é igual
        assertThat(resultado).isEqualTo(15);
        //se é menor que
        assertThat(resultado).isLessThan(20);
        //se é maior que
        assertThat(resultado).isGreaterThan(10);
        //se é positivo
        assertThat(resultado).isPositive();

        String str = "uma string boba";

        //se string náo é vazia
        assertThat(str).isNotEmpty();

        // com string da para verificar xml tamanho entre outras coisas
    }
}


