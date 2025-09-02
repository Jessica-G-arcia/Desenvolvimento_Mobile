package aps.com.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import aps.com.models.Curso; // Importa a classe abstrata
import aps.com.models.CursoComConteudo; // Importa a classe filha
import aps.com.models.ConteudoAula;

public class CursoController {

    private ArrayList<Curso> cursos = new ArrayList<>();
    
    public String novoCurso(String nome, String codigo, String duracao) {
        if (nome == null || nome.trim().isEmpty() ||
            codigo == null || codigo.trim().isEmpty() ||
            duracao == null || duracao.trim().isEmpty()) {
            return "Erro: Todos os campos (nome, codigo, duracao) são obrigatórios.";
        }
        
        if (buscarCursoPorCodigo(codigo) != null) {
            return "Erro: Já existe um curso com este código.";
        }

        // Instancia a classe filha, que implementa a funcionalidade completa
        CursoComConteudo novoCurso = new CursoComConteudo(nome, codigo, duracao);
        cursos.add(novoCurso);
        return "Curso '" + nome + "' criado com sucesso!";
    }
   
    public void cadastrarNovoCurso(Scanner scanner) {
        System.out.print("Digite o nome do curso: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o código do curso: ");
        String codigo = scanner.nextLine();

        System.out.print("Digite a duração do curso: ");
        String duracao = scanner.nextLine();

        String resultado = novoCurso(nome, codigo, duracao);
        System.out.println(resultado);
    }

    public void adicionarConteudoACurso(Scanner scanner) {
        System.out.print("Digite o código do curso para adicionar a ementa e o objetivo: ");
        String codigo = scanner.nextLine();

        Curso cursoEncontrado = buscarCursoPorCodigo(codigo);

        if (cursoEncontrado == null) {
            System.out.println("Erro: Curso com o código '" + codigo + "' não encontrado.");
            return;
        }

        // Verifica se o curso encontrado pode ter conteúdo (se ele é do tipo CursoComConteudo)
        if (!(cursoEncontrado instanceof CursoComConteudo)) {
            System.out.println("Erro: Este tipo de curso não aceita conteúdo.");
            return;
        }

        // Faz o "casting" para ter acesso aos métodos da classe filha
        CursoComConteudo cursoComConteudo = (CursoComConteudo) cursoEncontrado;

        System.out.print("Digite a ementa do curso: ");
        String ementa = scanner.nextLine();

        System.out.print("Digite o objetivo do curso: ");
        String objetivo = scanner.nextLine();
        
        ConteudoAula novoConteudo = new ConteudoAula(ementa, objetivo);
        cursoComConteudo.adicionarConteudo(novoConteudo);

        System.out.println("Conteúdo adicionado ao curso '" + cursoComConteudo.getNome() + "' com sucesso!");
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            System.out.println("\n--- Lista de Cursos ---");
            for (Curso curso : cursos) {
                System.out.println(curso); // Chama o toString(), que por sua vez chama o getDescricaoCompleta()
            }
        }
    }

    public String excluirCursoPorCodigo(String codigo) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigo().equals(codigo)) {
                cursos.remove(i);
                return "Curso excluído com sucesso!";
            }
        }
        return "Curso não encontrado!";
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    public Curso buscarCursoPorNome(String nome) {
    for (Curso curso : cursos) {
        if (curso.getNome().equalsIgnoreCase(nome)) {
            return curso;
        }
    }
    return null;
    }
    
}