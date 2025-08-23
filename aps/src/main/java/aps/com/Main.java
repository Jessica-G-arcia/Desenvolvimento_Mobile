package aps.com;

import java.util.Scanner;
import aps.com.controllers.AlunoController;
import aps.com.controllers.CursoController;
import aps.com.controllers.ProfessorController;

public class Main {
    public static void main(String[] args) {
        
        // Instancie os controladores na ordem correta
        CursoController cursoController = new CursoController();
        AlunoController alunoController = new AlunoController(cursoController);
        ProfessorController professorController = new ProfessorController(cursoController);
        
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Menu Principal ---");
            // Opções de Curso
            System.out.println("1. Cadastrar novo curso");
            System.out.println("2. Listar todos os cursos");
            System.out.println("3. Excluir curso por código");
            // Opções de Professor
            System.out.println("4. Cadastrar novo professor");
            System.out.println("5. Listar todos os professores");
            System.out.println("6. Listar professores por curso");
            // Opções de Aluno
            System.out.println("7. Cadastrar novo aluno");
            System.out.println("8. Listar todos os alunos");
            System.out.println("9. Listar alunos por curso");
            System.out.println("10. Remover aluno por RA");
            System.out.println("0. Sair do programa");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                // Casos de Curso
                case 1:
                    cursoController.cadastrarNovoCurso(scanner);
                    break;
                case 2:
                    cursoController.listarCursos();
                    break;
                case 3:
                    System.out.print("Digite o código do curso a ser excluído: ");
                    String codigoParaExcluir = scanner.nextLine();
                    System.out.println(cursoController.excluirCursoPorCodigo(codigoParaExcluir));
                    break;
                // Casos de Professor
                case 4:
                    professorController.cadastrarNovoProfessor(scanner);
                    break;
                case 5:
                    professorController.listarProfessores();
                    break;
                case 6:
                    System.out.print("Digite o nome do curso para listar os professores: ");
                    String cursoParaListarProfessores = scanner.nextLine();
                    professorController.listarProfessoresPorCurso(cursoParaListarProfessores);
                    break;
                // Casos de Aluno
                case 7:
                    alunoController.cadastrarNovoAluno(scanner);
                    break;
                case 8:
                    alunoController.listarAlunos();
                    break;
                case 9:
                    System.out.print("Digite o nome do curso para listar os alunos: ");
                    String cursoParaListarAlunos = scanner.nextLine();
                    alunoController.listarAlunosPorCurso(cursoParaListarAlunos);
                    break;
                case 10:
                    System.out.print("Digite o RA do aluno a ser removido: ");
                    String raParaRemover = scanner.nextLine();
                    System.out.println(alunoController.removerAlunoPorRA(raParaRemover));
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }
}