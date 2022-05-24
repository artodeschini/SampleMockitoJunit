package org.todeschini;

public class Calculadora {

    public int somar(int n1, int n2) {
        if (n1 < 0 || n2 < 0) {
            throw new RuntimeException("nao deve somar numeros negativos");
        }
        return n1 + n2;
    }

    public int subtrair(int n1, int n2) {
        return n1 - n2;
    }

    public int multiplicar(int n1, int n2) {
        return n1 * n2;
    }


    public int dividir(int n1, int n2) {
        if (n2 == 0) {
            throw new RuntimeException("divisao nao pode ser por zero");
        }
        return n1 / n2;
    }
}
