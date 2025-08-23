package aps.com.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import aps.com.models.Aluno;


public class AlunoController {
    
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private CursoController cursoController; // Atributo para armazenar a instância do CursoController

    // Construtor que recebe o CursoController
    public AlunoController(CursoController cursoController) {
        this.cursoController = cursoController;
    }

    public String novoAluno(String nome, String RA, String curso) {
        if (nome == null || nome.trim().isEmpty() ||
            RA == null || RA.trim().isEmpty() ||
            curso == null || curso.trim().isEmpty()) {
            return "Erro: Todos os campos (nome, RA, curso) são obrigatórios.";
        }

        // Validação: verifica se o curso existe antes de criar o aluno
        if (cursoController.buscarCursoPorNome(curso) == null) {
            return "Erro: O curso '" + curso + "' não existe. Por favor, cadastre o curso primeiro.";
        }
        
        Aluno novoAluno = new Aluno(nome, RA, curso);
        alunos.add(novoAluno);
        return "Aluno(a) '" + nome + "' criado com sucesso!";
    }

    public void cadastrarNovoAluno(Scanner scanner) {
        System.out.print("Digite o nome do(a) aluno(a): ");
        String nome = scanner.nextLine();

        System.out.print("Digite o RA do(a) aluno(a): ");
        String ra = scanner.nextLine();

        System.out.print("Digite o curso do(a) aluno(a): ");
        String curso = scanner.nextLine();

        String resultado = novoAluno(nome, ra, curso);
        System.out.println(resultado);
    }
    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\n--- Lista de Alunos ---");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }


    public String removerAlunoPorRA(String ra) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getRa().equals(ra)) {
                alunos.remove(i);
                return "Aluno(a) excluído com sucesso!";
            }
        }
        return "Aluno(a) não encontrado!";
    }

    public void listarAlunosPorCurso(String curso) {
        ArrayList<Aluno> alunosDoCurso = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getCurso() != null && aluno.getCurso().equalsIgnoreCase(curso)) {
                alunosDoCurso.add(aluno);
            }
        }
        
        if (alunosDoCurso.isEmpty()) {
            System.out.println("Nenhum aluno encontrado para o curso: " + curso);
        } else {
            System.out.println("\n--- Alunos do curso: " + curso + " ---");
            for (Aluno aluno : alunosDoCurso) {
                System.out.println(aluno);
            }
        }
    }
}