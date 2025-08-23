package aps.com.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import aps.com.models.Curso;

public class CursoController {

    private ArrayList<Curso> cursos = new ArrayList<>();
    
    public String novoCurso(String nome, String codigo, String duracao) {
        if (nome == null || nome.trim().isEmpty() ||
            codigo == null || codigo.trim().isEmpty() ||
            duracao == null || duracao.trim().isEmpty()) {
            return "Erro: Todos os campos (nome, codigo, duracao) são obrigatórios.";
        }
        
        Curso novoCurso = new Curso(nome, codigo, duracao);
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

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            System.out.println("\n--- Lista de Cursos ---");
            for (Curso curso : cursos) {
                System.out.println(curso);
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

    public Curso buscarCursoPorNome(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
            }
        }
        return null;
    }
}