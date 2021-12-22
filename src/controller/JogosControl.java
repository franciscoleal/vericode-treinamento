package controller;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.JogosModel;

public class JogosController {
	
	private static Scanner entrada;
	private static ArrayList<JogosModel> valores = new ArrayList<JogosModel>();
	
	
	public ArrayList<JogosModel> loader(String file){
		
		try {
			
			entrada = new Scanner(Paths.get(file), "UTF-8");
			
			entrada.nextLine();
			
			while(entrada.hasNext()) {
				String[] data = entrada.nextLine().split(",");
				
				JogosModel dados = new JogosModel();
		
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
