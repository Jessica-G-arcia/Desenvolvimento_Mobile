package com.example;

import com.example.aula1.Carro;
import com.example.aula1.Pessoa;

public class Main {
    public static void main(String[] args) {
        Carro c = new Carro();
        c.setPlaca("ABC1234");
        c.setAno(1980);
        c.setModelo("Fusca");
        c.setMarca("Volkswagen");

        Pessoa p1 = new Pessoa();
        p1.setNome("Carlos");
        System.out.println("Pessoa criada: " + p1.getNome());

        Pessoa p2 = new Pessoa("João");
        p2.setNome("João");

        System.out.println("Pessoa criada: " + p2.getNome());
        Pessoa p3 = new Pessoa("Maria", c);
        p3.setNome("Maria");
        p3.setC(c);
        System.out.println("Pessoa criada: " + p3.getNome() + ", Carro: " + p3.getC().getModelo() + ", Ano: " +p3.getC().getAno() + ", Placa: " + p3.getC().getPlaca());

    }
}