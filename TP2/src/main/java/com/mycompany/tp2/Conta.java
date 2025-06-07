package com.mycompany.tp2;

public abstract class Conta {
    protected String numeroConta;
    protected String nomeConta;
    protected String morada;
    protected double saldo;

    public Conta(String numeroConta, String nomeConta, String morada, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeConta = nomeConta;
        this.morada = morada;
        this.saldo = saldo;
    }

    // Métodos getters
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public String getMorada() {
        return morada;
    }

    public double getSaldo() {
        return saldo;
    }

    // Métodos setters
    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    // Métodos comuns
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public abstract boolean levantar(double valor); // método abstrato (cada tipo de conta terá regras diferentes)
}


