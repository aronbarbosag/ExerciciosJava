package Semana12.Dominio;
import Semana12.Dominio.Aluno;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class AlunoArrayList {
    private ArrayList<Aluno> alunosArray;
    private static final String nomeArquivo = "alunos.txt";
    public AlunoArrayList(){
        this.alunosArray = new ArrayList<>();
        carregarAlunos();
    }

    public void adicionarAluno(int matricula,String nome, double coeficienteRendimento){
        Aluno aluno = new Aluno(matricula,nome,coeficienteRendimento);
        alunosArray.add(aluno);
        System.out.println("Aluno adicionado com sucesso!");
        salvarAlunos();
    }

    public void listarAlunos(){
        if(alunosArray.isEmpty()){
            System.out.println("Nenhum aluno cadastrado");
        }
        else{
            System.out.println("Lista de alunos: ");
            for (Aluno aluno:alunosArray){
                aluno.listarAlunos();
            }
        }
    }

    public Aluno buscarAluno(int matricula){
        for(Aluno aluno:alunosArray){
            if (aluno.getMatricula()==matricula){
                return aluno;
            }

        }
        return null;

    }

    public boolean excluirAluno(int matricula) {
        Aluno alunoParaRemover = buscarAluno(matricula);
        if (alunoParaRemover != null) {
            alunosArray.remove(alunoParaRemover);
            System.out.println("Aluno com matrícula " + matricula + " excluído com sucesso.");
            return true;
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado para exclusão.");
            return false;
        }
    }

    public boolean alterarAluno(int matricula, String novoNome, double novoCoeficienteRendimento) {
        Aluno alunoParaAlterar = buscarAluno(matricula);
        if (alunoParaAlterar != null) {
            alunoParaAlterar.setNome(novoNome);
            alunoParaAlterar.setCoeficienteRendimento(novoCoeficienteRendimento);
            System.out.println("Aluno com matrícula " + matricula + " alterado com sucesso.");
            salvarAlunos();
            return true;
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado para alteração.");
            return false;
        }
    }

    private void salvarAlunos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Aluno aluno : alunosArray) {
                writer.write(aluno.getMatricula() + ";" + aluno.getNome() + ";" + aluno.getCoeficienteRendimento());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar alunos: " + e.getMessage()); // Usa System.err para erros
        }
    }

    private void carregarAlunos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    int matricula = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    double coeficienteRendimento = Double.parseDouble(dados[2]);
                    alunosArray.add(new Aluno(matricula, nome, coeficienteRendimento));
                } else {
                    System.err.println("Aviso: Linha mal formatada no arquivo de alunos: " + linha);
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo de alunos (" + nomeArquivo + ") não encontrado. Um novo será criado ao salvar.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar alunos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de formato numérico ao carregar alunos: " + e.getMessage());
            System.err.println("Verifique se o arquivo " + nomeArquivo + " não está corrompido.");
        }
    }
}
