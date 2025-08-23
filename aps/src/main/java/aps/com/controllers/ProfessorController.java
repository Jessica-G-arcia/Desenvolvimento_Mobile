package aps.com.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import aps.com.models.Professor;

public class ProfessorController {
    
    private ArrayList<Professor> professores = new ArrayList<>();
    private CursoController cursoController;

    // Construtor que recebe o CursoController
    public ProfessorController(CursoController cursoController) {
        this.cursoController = cursoController;
    }

    public String novoProfessor(String nome, String id, String curso) {
        if (nome == null || nome.trim().isEmpty() ||
            id == null || id.trim().isEmpty() ||
            curso == null || curso.trim().isEmpty()) {
            return "Erro: Todos os campos (nome, ID, curso) são obrigatórios.";
        }

        if (cursoController.buscarCursoPorNome(curso) == null) {
            return "Erro: O curso '" + curso + "' não existe. Por favor, cadastre o curso primeiro.";
        }
        
        Professor novoProfessor = new Professor(nome, id, curso);
        professores.add(novoProfessor);
        return "Professor(a) '" + nome + "' criado com sucesso!";
    }

    public void cadastrarNovoProfessor(Scanner scanner) {
        System.out.print("Digite o nome do(a) professor(a): ");
        String nome = scanner.nextLine();

        System.out.print("Digite o ID do(a) professor(a): ");
        String id = scanner.nextLine();

        System.out.print("Digite o curso do(a) professor(a): ");
        String curso = scanner.nextLine();

        String resultado = novoProfessor(nome, id, curso);
        System.out.println(resultado);
    }
    
    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            System.out.println("\n--- Lista de Professores ---");
            for (Professor professor : professores) {
                System.out.println(professor);
            }
        }
    }

    public void listarProfessoresPorCurso(String curso) {
        ArrayList<Professor> professoresDoCurso = new ArrayList<>();
        for (Professor professor : professores) {
            if (professor.getCurso() != null && professor.getCurso().equalsIgnoreCase(curso)) {
                professoresDoCurso.add(professor);
            }
        }
        
        if (professoresDoCurso.isEmpty()) {
            System.out.println("Nenhum professor encontrado para o curso: " + curso);
        } else {
            System.out.println("\n--- Professores do curso: " + curso + " ---");
            for (Professor professor : professoresDoCurso) {
                System.out.println(professor);
            }
        }
    }
}