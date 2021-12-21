package model;

public class JogosModel {
	
	private String rank;
	private String name;
	private String platform;
	private String year;
	private String genre;
	private String publisher;
	private String naSales;
	private String euSales;
	private String jpSales;
	private String otherSales;
	private Double globalSales;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public Double getGlobalSales() {
		return globalSales;
	}
	public void setGlobalSales(Double globalSales) {
		this.globalSales = globalSales;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
	@Override
	public String toString() {
		return "InstanceModel [rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year
				+ ", genre=" + genre + ", publisher=" + publisher + ", naSales=" + naSales + ", euSales=" + euSales
				+ ", jpSales=" + jpSales + ", otherSales=" + otherSales + ", globalSales=" + globalSales + "]";
	}
	
}
