package external;

import java.io.*;

import domain.*;
/**
 * Reads a txt file's details and converts the contents into a array, taking in the first line as the size of the array
 * and the following lines being the product type, original price and update price separated by spaces.
 * 
 * @author Edwin Guo
 */
public class ReadData {
	/**
	 * Process a text file and converts it into an array of type Product
	 * @param file The directory of the file
	 * @return The contents of a file as an array
	 */
	public static Product[] readData(String file) {
		Product[] productArray = null;
		// Used to read each line in the file, closes and opens automatically within try catch
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			// Reads the first line and gets the size of the array, creating an array of that size
			String line = reader.readLine();
			int arraySize = Integer.parseInt(line);
			productArray = new Product[arraySize];
			// Reads through every line of the file based on provided array size, splitting each line by spaces
			for (int i = 0; i < arraySize; i++) {
				line = reader.readLine();
				String[] parts = line.trim().split(" ");
				// Separates the line into the required parts to be made into a product object
				String productType = parts[0];
				double originalPrice = Double.parseDouble(parts[1]);
				double updatedPrice = Double.parseDouble(parts[2]);
				// Checks the provided file type and creates an object of that type
				switch(productType) {
					case "Jeans":
						productArray[i] = new Jeans(originalPrice, updatedPrice);
						break;
					case "TShirts":
						productArray[i] = new TShirts(originalPrice, updatedPrice);
						break;
					case "Skirts":
						productArray[i] = new Skirts(originalPrice, updatedPrice);
						break;
					case "Dresses":
						productArray[i] = new Dresses(originalPrice, updatedPrice);
						break;
					case "Shorts":
						productArray[i] = new Shorts(originalPrice, updatedPrice);
						break;
					case "Jackets":
						productArray[i] = new Jackets(originalPrice, updatedPrice);
						break;
					case "Shoes":
						productArray[i] = new Shoes(originalPrice, updatedPrice);
						break;
				}
				
			}
		// Catches for file not found exceptions and any potential file reading issues and prints them.
		} catch (FileNotFoundException e){
			System.out.println("Specified file was not found. Please check the file path.");
		} catch (IOException ex) {
			System.out.println("Error reading file found " + ex);
		}
		return productArray;
		
	}
}
