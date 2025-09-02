package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.aula1.Carro;
import com.example.aula2.Pessoa;
import com.example.aula2.Calculadora;
import com.example.aula2.ContaCorrente;
import com.example.aula2.Animal;
import com.example.aula2.Animal1;

public class Main {
    public static void main(String[] args) {
        // Carro c = new Carro();
        // c.setPlaca("ABC1234");
        // c.setAno(1980);
        // c.setModelo("Fusca");
        // c.setMarca("Volkswagen");

        // Pessoa p1 = new Pessoa();
        // p1.setNome("Carlos");
        // System.out.println("Pessoa criada: " + p1.getNome());

        // Pessoa p2 = new Pessoa("João");
        // p2.setNome("João");

        // System.out.println("Pessoa criada: " + p2.getNome());
        // Pessoa p3 = new Pessoa("Maria", c);
        // p3.setNome("Maria");
        // p3.setC(c);
        // System.out.println("Pessoa criada: " + p3.getNome() + ", Carro: " + p3.getC().getModelo() + ", Ano: " +p3.getC().getAno() + ", Placa: " + p3.getC().getPlaca());

        // Animal animal = new Animal();
        // animal.fazerSom();

        // animal = new Cachorro();
        // animal.fazerSom(); 


        // Cachorro cachorro = new Cachorro();
        // cachorro.fazerSom();

        // Calculadora calc = new Calculadora();
        // int resultado1 = calc.somar(5, 10);
        // double resultado2 = calc.somar(5.5, 10.2);
        // int resultado3 = calc.somar(1, 2, 3);
        // System.out.println("Resultado1: " + resultado1);
        // System.out.println("Resultado2: " + resultado2);
        // System.out.println("Resultado3: " + resultado3);

        // List<Pessoa> pessoas = new ArrayList<Pessoa>();

        // Pessoa pessoa1 = new Pessoa("Ana", 25);
        // Pessoa pessoa2 = new Pessoa("Bruno", 30);
        // Pessoa pessoa3 = new Pessoa("Carla", 28);

        // pessoas.add(pessoa1);
        // pessoas.add(pessoa2);
        // pessoas.add(pessoa3);

        // // exibirPessoas(pessoas);
        // exibirPessoas2(pessoas);

        // Animal1 animal1 = new Animal1();
        // animal1.emiteSom();

        ContaCorrente conta = new ContaCorrente();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
    
        conta.definirSaldoInicial(1000);
        System.out.println("Saldo inicial: R$ " + conta.getSaldo());

        System.out.print("Digite o valor do depósito: ");
        float valorDeposito = scanner.nextFloat();
        conta.depositar(valorDeposito);
        System.out.println("Saldo após depósito: R$ " + conta.getSaldo());

        System.out.print("Digite o valor do saque: R$ ");
        float valorSaque = scanner.nextFloat();
        boolean podeSacar = conta.podeSacar(valorSaque);
        System.out.println("Pode sacar?" + (podeSacar ? " Sim" : " Não"));
        if (podeSacar) {
            conta.sacar(valorSaque);
        }
        System.out.println("Saldo após saque: R$ " + conta.getSaldo());

        scanner.close();
    }

    // public static void exibirPessoas(List<Pessoa> pessoas) {
    //     System.out.println("Lista de Pessoas:");
    //     for (Pessoa p : pessoas) {
    //         System.out.println("Nome: " + p.getNome());
    //         System.out.println("Idade: " + p.getIdade());
    //     }
    // }

    // private static void exibirPessoas2(List<Pessoa> lista) {
    //     for (int i=0;i<lista.size();i++) {
    //         Pessoa p = (Pessoa) lista.get(i);
    //         System.out.println("Nome: " + p.getNome());
    //         System.out.println("Idade: " + p.getIdade());
    //     }
    // }


}