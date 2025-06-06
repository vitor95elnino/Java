package com.mycompany.gestaocontas;

public class ContaService {

    private Conta conta; // Apenas uma conta ativa

    public void criar(Conta conta) {
        this.conta = conta;
    }

    public Conta consultar(String numero) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            return conta;
        }
        return null;
    }

    public boolean alterar(String numero, String novoNome, String novaMorada) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            conta.setNomeConta(novoNome);
            conta.setMorada(novaMorada);
            return true;
        }
        return false;
    }

    public boolean eliminar(String numero) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            conta = null;
            return true;
        }
        return false;
    }

    public boolean depositar(String numero, double valor) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean levantar(String numero, double valor) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            return conta.levantar(valor);
        }
        return false;
    }

    public boolean transferir(String deConta, String paraConta, double valor) {
        // Só existe uma conta ativa, por isso não é possível transferir
        System.out.println("Transferência não disponível: só existe uma conta ativa.");
        return false;
    }
}
