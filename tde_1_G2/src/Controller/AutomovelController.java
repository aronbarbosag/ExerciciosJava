package Controller;
import Dominio.AutomovelArrayList;
import Dominio.Automovel;
import java.util.Scanner;
public class AutomovelController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao= 0;
		boolean flag = false;
		String placa,modelo, marca;
		int ano;
		double valor;
		
		//String placa, String modelo, String marca, int ano, double valor
		AutomovelArrayList automoveis = new AutomovelArrayList();
		while(!flag) {
		
		System.out.println("Escolha uma opção: ");
		System.out.println("(1) Cadastrar veiculo. ");
		System.out.println("(2) Buscar veiculo. ");
		System.out.println("(3) Alterar veiculo. ");
		System.out.println("(4) Excluir veiculo. ");
		System.out.println("(5) Mostrar todos os veiculos. ");
		System.out.println("(0) Sair do programa. ");
		
		opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
		case 0:
			System.out.println("Saindo do programa...");
			flag = true;
			break;
		
		case 1:
			System.out.println("Placa do veiculo: ");
			placa = sc.nextLine();
			System.out.println("Modelo do veiculo: ");
			modelo = sc.nextLine();
			System.out.println("Marca do veiculo: ");
			marca = sc.nextLine();
			System.out.println("Ano do veiculo: ");
			ano = sc.nextInt();
			System.out.println("Valor do veiculo: ");
			valor = sc.nextDouble();
			
			
			automoveis.adicionarAutomovel(placa, modelo, marca, ano, valor);
			break;
		case 2:
			System.out.println("Placa do veiculo: ");
			placa = sc.nextLine();
			Automovel veiculoAchado = automoveis.buscarAutomovel(placa);
			veiculoAchado.mostrarAutomovel();
			break;
		case 3:
			System.out.println("Placa do veiculo: ");
			placa = sc.nextLine();
            sc.nextLine();
            System.out.println("Modelo do veiculo: ");
			modelo = sc.nextLine();
			System.out.println("Marca do veiculo: ");
			marca = sc.nextLine();
			System.out.println("Ano do veiculo: ");
			ano = sc.nextInt();
			System.out.println("Valor do veiculo: ");
			valor = sc.nextDouble();;
            automoveis.alterarAutomovel(placa, modelo, marca, ano, valor);
            
            break;
            
		case 4:
			System.out.println("Placa do veiculo: ");
			placa = sc.nextLine();
            automoveis.excluirAutomovel(placa);
            break;
		
		case 5:
			automoveis.mostrarAutomoveis();
			break;
		default:
			System.out.println("Opção não encontrada");
			flag = true;
			
		}// fim switch
		
		
		
		
		}//fim loop
		sc.close();
	}

}
