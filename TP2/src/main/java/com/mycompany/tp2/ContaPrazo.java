package com.mycompany.tp2;

public class ContaPrazo extends Conta {
    private int prazoDias;
    private String dataCriacao;
    private double taxaJuro;

    public ContaPrazo(String numeroConta, String nomeConta, String morada, double saldo,
                      int prazoDias, String dataCriacao, double taxaJuro) {
        super(numeroConta, nomeConta, morada, saldo);
        this.prazoDias = prazoDias;
        this.dataCriacao = dataCriacao;
        this.taxaJuro = taxaJuro;
    }

    @Override
    public boolean levantar(double valor) {
        // regra simplificada: não permite levantamento antes do prazo
        System.out.println("Levantamento não permitido em conta a prazo.");
        return false;
    }
}
