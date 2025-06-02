package Dominio;
import Dominio.Automovel;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class AutomovelArrayList {
	private ArrayList<Automovel> automoveis;
	 private static final String nomeArquivo = "./src/DataBase/automoveis.txt";
	
	public AutomovelArrayList() {
		this.automoveis = new ArrayList<>();
		 carregarAutomoveis();
	}
	
	public void adicionarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
		Automovel automovel = new Automovel(placa,modelo,marca,ano,valor);
		automoveis.add(automovel);
		salvarAutomoveis();
	}
	
	public Automovel buscarAutomovel(String placa) {
		for(Automovel veiculo:automoveis) {
			if(veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}
		}
		return null;
	}
	
	public boolean alterarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
		Automovel veiculoAchado =this.buscarAutomovel(placa);
		if (veiculoAchado != null) {
			veiculoAchado.setModelo(modelo);
			veiculoAchado.setMarca(marca);
			veiculoAchado.setAno(ano);
			veiculoAchado.setValor(valor);
            System.out.println("Automovel com placa " + placa + " alterado com sucesso.");
            salvarAutomoveis();
            return true;
        } else {
            System.out.println("Automovel com placa " + placa + " NÃO encontrado.");
            return false;
        }
	}
	
	public boolean excluirAutomovel(String placa) {
		Automovel veiculoAchado =this.buscarAutomovel(placa);
        if (veiculoAchado != null) {
        	automoveis.remove(veiculoAchado);
        	System.out.println("Automovel com placa " + placa + " alterado com sucesso.");
            return true;
        } else {
        	System.out.println("Automovel com placa " + placa + " NÃO encontrado.");
            return false;
        }
    }
	
	public void mostrarAutomoveis() {
		for(Automovel veiculo:automoveis) {
			veiculo.mostrarAutomovel();
		}
	}
	
	private void carregarAutomoveis() {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String placa = dados[0];
                    String modelo = dados[1];
                    String marca = dados[2];
                    int ano = Integer.parseInt(dados[3]);
                    double valor = Double.parseDouble(dados[4]);
                    automoveis.add(new Automovel(placa, modelo, marca,ano,valor));
                } else {
                    System.err.println("Aviso: Linha mal formatada no arquivo de automoveis: " + linha);
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo de automoveis (" + nomeArquivo + ") não encontrado. Um novo será criado ao salvar.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar automoveis: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de formato numérico ao carregar automoveis: " + e.getMessage());
            System.err.println("Verifique se o arquivo " + nomeArquivo + " não está corrompido.");
        }
    }
	

	
	private void salvarAutomoveis() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Automovel automovel : automoveis) {
                writer.write(automovel.getPlaca() + ";" + automovel.getModelo() + ";" + automovel.getMarca() + ";" + automovel.getAno() + ";" + automovel.getValor());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar automoveis: " + e.getMessage()); // Usa System.err para erros
        }
    }
}
