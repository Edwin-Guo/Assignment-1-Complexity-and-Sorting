package external;

import java.io.*;

import domain.*;

public class ReadData {
	public static Product[] readData(String file) {
		Product[] productArray = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line = reader.readLine();
			int arraySize = Integer.parseInt(line);
			productArray = new Product[arraySize];
			
			for (int i = 0; i < arraySize; i++) {
				String[] parts = line.trim().split(" ");
				String productType = parts[0];
				double originalPrice = Double.parseDouble(parts[1]);
				double updatedPrice = Double.parseDouble(parts[2]);
				switch(productType) {
					case "Jeans":
						productArray[i] = new Jeans(originalPrice, updatedPrice);
						break;
					case "TShirts":
						productArray[i] = new TShirt(originalPrice, updatedPrice);
						break;
					case "Skirts":
						productArray[i] = new Skirt(originalPrice, updatedPrice);
						break;
					case "Dresses":
						productArray[i] = new Dress(originalPrice, updatedPrice);
						break;
					case "Shorts":
						productArray[i] = new Shorts(originalPrice, updatedPrice);
						break;
					case "Jackets":
						productArray[i] = new Jacket(originalPrice, updatedPrice);
						break;
					case "Shoes":
						productArray[i] = new Shoes(originalPrice, updatedPrice);
						break;
				}
				
			}
		} catch (FileNotFoundException e){
			System.out.println("Specified file was not found.");
		} catch (IOException ex) {
			System.out.println("Error reading file found " + ex);
		}
		return productArray;
		
	}
}
