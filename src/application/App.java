package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int quantity = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		for (int qproduct = 0; qproduct < quantity; qproduct++) {
			
			System.out.println("Product #" + (qproduct+1) + " data: ");
			
			System.out.print("Common, used or irported: (c/u/i)? ");
			String choise = sc.nextLine();
			
			System.out.print("Name: ");
			String productName = sc.nextLine();
			
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			sc.nextLine();
			
			if (choise.equals("c")) {
				Product product = new Product(productName, productPrice);
				products.add(product);
			}else if (choise.equals("i")) {
				System.out.print("Customs Fee: ");
				double customsFee = sc.nextDouble();
				sc.nextLine();
				Product product = new ImportedProduct(productName, productPrice, customsFee);
				products.add(product);
			}else {
				System.out.print("Manufacture date: ");
				Date manufactureDate = sdf.parse(sc.next());
				Product product = new UsedProduct(productName, productPrice, manufactureDate);
				products.add(product);
			}
			
		}
		
		System.out.println();
		
		for(Product p : products) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}
	
}
