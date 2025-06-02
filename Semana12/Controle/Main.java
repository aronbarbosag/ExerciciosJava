package Semana12.Controle;
import Semana12.Dominio.Aluno;
import Semana12.Dominio.AlunoArrayList;
import  java.util.Scanner;
public  class  Main{

    public static void main(String[] args) {
        AlunoArrayList alunos = new AlunoArrayList();
        int escolha = 0;
        boolean sinalParada = false;
        Scanner sc = new Scanner(System.in);
        while (!sinalParada) {
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("(1) - Cadastrar aluno. ");
            System.out.println("(2) - Buscar aluno. ");
            System.out.println("(3) - Alterar aluno. ");
            System.out.println("(4) - Excluir aluno. ");
            System.out.println("(5) - Visualizar todos os alunos. ");
            System.out.println("(0) - Sair do programa. ");

            escolha = sc.nextInt();
            int matricula=0;
            switch (escolha) {
                case 0:
                    sinalParada = true;
                    break;

                case 1:
                    System.out.println("numero da matricula: ");
                    matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.println("nome: ");
                    String nome = sc.nextLine();
                    System.out.println("CR: ");
                    double cr = sc.nextDouble();
                    sc.nextLine();
                    alunos.adicionarAluno(matricula, nome, cr);
                    break;
                case 2:
                    System.out.println("numero da matricula: ");
                    matricula = sc.nextInt();
                    Aluno alunoAchado =alunos.buscarAluno(matricula);
                    alunoAchado.listarAlunos();
                    break;
                case 3:
                    System.out.println("numero da matricula: ");
                    matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.println("Digite o CR: ");
                    double novoCR=sc.nextDouble();
                    alunos.alterarAluno(matricula,novoNome,novoCR);
                    break;
                case 4:
                    System.out.println("numero da matricula: ");
                    matricula = sc.nextInt();
                    alunos.excluirAluno(matricula);
                    break;
                case 5:
                    alunos.listarAlunos();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }


        }
        sc.close();
    }
}
