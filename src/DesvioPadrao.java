import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import view.InstanceView;

public class DesvioPadrao {
	
	public DesvioPadrao() throws Exception {
		
		InstanceView dados = new InstanceView();
		Media media = new Media();
		
		double desvioPadrao = 0.0; // desvio padrão
		List<Double> lista = new ArrayList<>();
		
		lista.add(dados.globalSales);
		
		for (double listaD : lista) {
			desvioPadrao = desvioPadrao + Math.pow(listaD - media.media, 2);
		}
		System.out.format(Locale.US, "Desvio Padrão Amostral: %.2f", +  Math.sqrt((desvioPadrao / dados.tam)) * 1000000);
		
	}
}
