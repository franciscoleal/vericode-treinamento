import view.InstanceView;

public class Media {
	
	public double media = 0.0;
	
	public Media() throws Exception {
		InstanceView dados = new InstanceView();
						
		double global = dados.somaGlobalSales;
		double qtd = dados.tam;
		
		// agora obtemos a média do conjunto de dados
		media = (global / qtd);
		System.out.println("Media: " + media);
//		System.out.format(Locale.US, "A Media é: %.2f \n", media * 1000000);
	}
}
