package com.example.aula2;

public class ContaCorrente {
    private float saldo;

    public float definirSaldoInicial (float saldo){
        this.saldo = saldo;
        return saldo;
    }

    public float depositar (float valor){
        this.saldo += valor;
        return saldo;
    }

    public boolean podeSacar (float valor){
        if (valor < saldo) {
            return true;
        } else {
            return false;
        }
    }

    public float sacar (float valor){
        if (podeSacar(valor)) {
            this.saldo -= valor;
        }
        return saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
