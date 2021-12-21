import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Leitor {
	public static void main(String[] args) {
		String csvArquivo = "C:\\tmp\\saida\\vgsales.csv";
		
		BufferedReader conteudoCSV = null;
		
		String linha = "";
		
		String cvsSeparador = ",";
		
		try {
			
			conteudoCSV = new BufferedReader (new FileReader(csvArquivo));
			
			while(linha != null) {
				linha = conteudoCSV.readLine();
//				System.out.println(linha);
				
				
				
//				System.out.println(
//						"[Rank = " + valor[0] + 
//						" , Col 1 = " + valor[1] + 
//						" , Col 2 = " + valor[2] + 
//						" , Col 3 = " + valor[3] + 
//						" , Col 4 = " + valor[4] + 
//						" , Col 5 = " + valor[5] +
//						" , Col 6 = " + valor[6] + 
//						" , Col 7 = " + valor[7] + 
//						" , Col 8 = " + valor[8] +
//						" , Col 9 = " + valor[9] + 
//						" , Col 10 = " + valor[10] + "]");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: \n"+e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBounds: \n"+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Erro: \n"+e.getMessage());
		} finally {
			if (conteudoCSV != null) {
				try {
					conteudoCSV.close();
				} catch (IOException e) {
					System.out.println("IO Erro: \n"+e.getMessage());
				}
			}
		}
	}
}
