package com.mycompany.gestaocontas;

public class ContaOrdem extends Conta {
    protected double saldoMinimo;
    protected boolean temCartaoCredito;

    public ContaOrdem(String numeroConta, String nomeConta, String morada, double saldo,
                      double saldoMinimo, boolean temCartaoCredito) {
        super(numeroConta, nomeConta, morada, saldo);
        this.saldoMinimo = saldoMinimo;
        this.temCartaoCredito = temCartaoCredito;
    }

    @Override
    public boolean levantar(double valor) {
        if (valor > 0 && saldo - valor >= saldoMinimo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

