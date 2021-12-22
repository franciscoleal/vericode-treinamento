package view;

import java.io.File;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import controller.JogosControl;
import model.JogosModel;

public class JogosView {
	
	public double somaGlobalSales;
	public ArrayList<JogosModel> valores;
	public double totalDeRegistros;

	public JogosView() throws Exception {
		
		double desvioPadrao = 0.0; // desvio padr�o
		double CalcularMedia = 0.0; // media
		List<Double> lista = new ArrayList<>(); // recebe valor da coluna globalSales
		int listInt = 0; // recebe o parse da lista de string dos anos
		String retiraTudoQueEString = ""; // regex que tira tudo que � string
		
		
//		passo o path do arquivo que ser� lido pelo metodo loader da classe JogosControl
		valores = new JogosControl().loader("C:\\tmp\\saida\\vgsales.csv");
	
//		fa�o a escrita no arquivo com os nomes dos jogos acima do ano 2000 e acima de 2 milh�es
		PrintWriter salvaNomesNoTxt = new PrintWriter(new File("nomesDosJogos.txt"));
		
//		recupero o total de registros
		totalDeRegistros = valores.size();
		
//		imprimo a quantidade de registros
		System.out.println("Quantidade de Registros: " + NumberFormat
											.getIntegerInstance()
											.format(totalDeRegistros) );


		for (JogosModel valor : valores) {
//			somat�rio da coluna globalSales	
			somaGlobalSales += valor.getGlobalSales();
//			adiciono a list os valores da coluna globalSales para efetuar o calculo do desvio padr�o
			lista.add(valor.getGlobalSales());
			
			
			
			
//			fiz um regex para tirar tudo que era String
			retiraTudoQueEString = valor.getYear().replaceAll("[^0-9.]", "");	
//			fa�o uma verifica��o se tudo que sobrou iguala aos anos
			if(retiraTudoQueEString.length() == 4) {
//				crio a variavel para verificar os jogos ap�s o ano 2000
				int jogosLancadosAposAno = 2000;
//				fa�o um parse da lista de anos de string para integer
				listInt =  Integer.parseInt(retiraTudoQueEString);
//				comparo se o ano � acima do ano 2000 e se � acima de 2 milh�es
				if (listInt > jogosLancadosAposAno && valor.getGlobalSales() > 2f ) {
//					System.out.println(valor.getName() + " : " + valor.getGlobalSales());
//					System.out.println(" Acima de 2 milh�es ap�s o ano 2000: " + valor.getName());

//					salvo os nomes no txt - 643 registros no total
					salvaNomesNoTxt.println(valor.getName());
				}
				
			}
		}
		
		
//		imprime o total da coluna globalSales
		System.out.println("Total GlobalSales: " + NumberFormat
							.getIntegerInstance()
							.format(somaGlobalSales * 1000000));
		
		// calcula a media 
		CalcularMedia = (somaGlobalSales / totalDeRegistros);
		System.out.println("Media: " + NumberFormat
								.getIntegerInstance()
								.format(CalcularMedia * 1000000));
		
		
//		calcula o desvio padr�o amostral
		for (double listaD : lista) {
			desvioPadrao += Math.pow(listaD - CalcularMedia, 2);
		}
//		imprime o desvio padr�o
//		divide-se o somat�rio pela quantidade de elementos do conjunto
		System.out.println("Desvio Padr�o Amostral: " + NumberFormat
														.getIntegerInstance()
	    												.format(Math.sqrt(desvioPadrao / totalDeRegistros) * 1000000));
		
		
		
		
		
//		fecho o printStream
		salvaNomesNoTxt.close();
	}
	
}
