package com.example.aula1;

public class Pessoa {
    private String nome;
    private Carro c;

    public Pessoa(){

    }

    public Pessoa(String nome) {
        this.nome = nome;
        c = null;
    }

    public Pessoa(String nome, Carro c) {
        this.nome = nome;
        this.c = c;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carro getC() {
        return c;
    }

    public void setC(Carro c) {
        this.c = c;
    }
}
