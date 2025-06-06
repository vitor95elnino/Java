package com.mycompany.gestaocontas;

public class ContaOrdenado extends ContaOrdem {
    private double limiteNegativo;

    public ContaOrdenado(String numeroConta, String nomeConta, String morada, double saldo,
                         double saldoMinimo, boolean temCartaoCredito, double limiteNegativo) {
        super(numeroConta, nomeConta, morada, saldo, saldoMinimo, temCartaoCredito);
        this.limiteNegativo = limiteNegativo;
    }

    @Override
    public boolean levantar(double valor) {
        if (valor > 0 && saldo - valor >= -limiteNegativo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

