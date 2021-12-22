package controller;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.JogosModel;

public class JogosControl {
	
//	vai ler o arquivo
	private static Scanner entrada;
//	recebe os dados do csv utilizando tmb o formato de JogosModel
	private static ArrayList<JogosModel> valores = new ArrayList<JogosModel>();
	
	
//	o metodo retorna o que foi lido no arquivo dentro desse formato do JogosModel
//	e passa um parametro para recebimento do arquivo..
	public ArrayList<JogosModel> loader(String file){
		
		try {
//			faz a leitura do arquivo csv
			entrada = new Scanner(Paths.get(file), "UTF-8");
			
//			faz uma leitura vazia e ignora o cabeçalho
			entrada.nextLine();
			
//			enquanto existir proxima linha faça
			while(entrada.hasNext()) {
//				guardo no array as linhas separadas sem as virgulas
				String[] data = entrada.nextLine().split(",");
				
//				recebo os valores no formato do JogosModel 
				JogosModel dados = new JogosModel();
		
//				recebo cada campo do arquivo
				dados.setRank(data[0]);
				dados.setName(data[1]);
//				dados.setPlatform(data[2]);
				dados.setYear(data[3]);
//				dados.setGenre(data[4]);
//				dados.setPublisher(data[5]);
//				dados.setNaSales(data[6]);
//				dados.setEuSales(data[7]);
//				dados.setJpSales(data[8]);
//				dados.setOtherSales(data[9]);
				dados.setGlobalSales(Double.parseDouble(data[10]));
				
				valores.add(dados);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro" + e.getMessage());
		}
		return valores;
	}
	
	
}
