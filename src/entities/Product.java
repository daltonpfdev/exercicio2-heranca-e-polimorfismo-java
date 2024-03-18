package entities;

public class Product {
	
	private String name;
	protected Double price;
	
	public Product() {
		
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}
	
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " $ " + price);
		return sb.toString();
	}
	
}
