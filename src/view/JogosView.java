package view;

import java.io.File;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import controller.JogosController;
import model.JogosModel;

public class JogosView {

	public double globalSales;
	public double somaGlobalSales;
	public ArrayList<JogosModel> valores;
	public double tam;

	public JogosView() throws Exception {
		
		double desvioPadrao = 0.0; // desvio padrão
		double media = 0.0; // media
		List<Double> lista = new ArrayList<>();
//		List<String> listAno = new ArrayList<>();
		int listInt = 0;
		String text = "";
		
		
		valores = new JogosController().loader("C:\\tmp\\saida\\vgsales.csv");
		
		PrintWriter s = new PrintWriter(new File("nomesDosJogos.txt"));
		
		tam = valores.size();
		
		System.out.println("Quantidade de Registros: " + tam);
		
		for (JogosModel n : valores) {
			somaGlobalSales += n.getGlobalSales();
			globalSales = n.getGlobalSales();
			lista.add(n.getGlobalSales());
		}
		
		System.out.println("Total GlobalSales: " + NumberFormat
							.getIntegerInstance()
							.format(somaGlobalSales * 1000000));
		
		//media
		media = (somaGlobalSales / tam);
		System.out.println("Media: " + NumberFormat
								.getIntegerInstance()
								.format(media * 1000000));
		
		//desvio
		for (double listaD : lista) {
			desvioPadrao += Math.pow(listaD - media, 2);
		}
		
		System.out.println("Desvio Padrão Amostral: " + NumberFormat
														.getIntegerInstance()
	    												.format(Math.sqrt(desvioPadrao / tam) * 1000000));
		
		System.out.println();
		
		
		
		for (JogosModel valor : valores) {
			text = valor.getYear().replaceAll("[^0-9.]", "");	
			if(text.length() == 4) {
				int jogosLancadosAposAno = 2000;
				listInt =  Integer.parseInt(text);
				if (listInt > jogosLancadosAposAno && valor.getGlobalSales() > 2f ) {
//					System.out.println(valor.getName() + " : " + valor.getGlobalSales());
//					System.out.println(" Acima de 2 milhões após o ano 2000: " + valor.getName());	
					s.println(valor.getName());
				}
				
			}
		}	
		s.close();
	}
	
}
