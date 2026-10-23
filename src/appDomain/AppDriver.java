package appDomain;

import java.util.Comparator;
import external.*;
import utilities.BubbleSort;
import utilities.InsertionSort;
import utilities.MergeSort;
import utilities.ShellSort;
import utilities.QuickSort;
import domain.Product;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		Comparator<Product> comp;
		String compType = "empty";
		String sortAlg = null;
		String file = null;
		Product[] products;
		
		long initialTime;
		long totalTime;
		
		if (args.length < 3 || args.length > 3) {
			System.out.println("Insufficient parameter count provided for the program to run smoothly.");
			System.out.println("The following is required: \"-f<file_name> -t<compare_type> -s<sort_alg>\"");
		} else {
			for (int i = 0; i < args.length; i++) {
				String arg = args[i].substring(0,2).toLowerCase();
				switch (arg) {
					case "-f":
						file = args[i].substring(2);
						break;
					case "-t":
						compType = args[i].substring(2).toLowerCase();
						break;
					case "-s":
						sortAlg = args[i].substring(2).toLowerCase();
						break;
					default:
						System.out.println("Invalid argument found: " + arg);
				}
			}
		}
		
		if (compType.equals("empty") || sortAlg == null || file == null) {
			System.out.println("An argument is missing, please provide \"-f<file_name> -t<compare_type> -s<sort_alg>\"");
			return;
		}
		products = ReadData.readData(file);
		if (products == null) {
			return;
		}
		
		switch (compType) {
			case "o":
				compType = "Original Price";
				comp = new OriginalPriceCompare();
				break;
			case "u":
				compType = "Updated Price";
				comp = new UpdatedPriceCompare();
				break;
			case "d":
				compType = "Real Difference";
				comp = null;
				break;
			default:
				System.out.println("Comparison type provided is invalid, please provide one of the following: \"o\", \"u\", \"d\". ");
				return;
		}
		
		switch (sortAlg) {
			case "b":
				sortAlg = "Bubble Sort";
				initialTime = System.currentTimeMillis();
				BubbleSort.sort(products, comp);
				totalTime = System.currentTimeMillis() - initialTime;
				break;
			case "s":
				sortAlg = "Selection Sort";
				initialTime = System.currentTimeMillis();
				System.out.println("Unable to select selection sort, get it?");
//				SelectSort.selectionSort(products, comp);
				totalTime = System.currentTimeMillis() - initialTime;
				break;
			case "i":
				sortAlg = "Insertion Sort";
				initialTime = System.currentTimeMillis();
				InsertionSort.sort(products, comp);
				totalTime = System.currentTimeMillis() - initialTime;
				break;
			case "m":
				sortAlg = "Merge Sort";
				initialTime = System.currentTimeMillis();
				MergeSort.sort(products, comp);
				totalTime = System.currentTimeMillis() - initialTime;
				break;
			case "q":
				sortAlg = "Quick Sort";
				initialTime = System.currentTimeMillis();
				QuickSort.sort(products, comp);
				totalTime = System.currentTimeMillis() - initialTime;
				break;
			case "z":
				sortAlg = "Shell Sort";
				initialTime = System.currentTimeMillis();
				ShellSort.sort(products, comp);
				totalTime = System.currentTimeMillis() - initialTime;
				break;
			default:
				System.out.println("Sort Algorithm provided is invalid, please provide one of the following: \"b\", \"s\", \"i\", \"m\", \"q\", \"z\".");
				return;
		}
		
		int inc = 0;
		int lastIndex = products.length-1;
		if(products.length <= 10) {
			inc = 1;
		} else if (products.length <= 1000) {
			inc = 100;
		} else {
			inc = 1000;
		}
		System.out.println("Element 1:\t" + products[0].getClass() + "\t" + compType + ": " + getSortVal(products[0], compType));
		if (inc == 1) {
			for (int i = 1; i < products.length; i++) {
				System.out.println( "Element " + (i+1) +":\t" + products[i].getClass() + "\t" + compType + ": " + getSortVal(products[i], compType));
			}
		} else {
			for (int i = inc; i < products.length; i+=inc) {
				System.out.println( "Element " + i +":\t" + products[i].getClass() + "\t" + compType + ": " + getSortVal(products[i], compType));
			}
			System.out.println("Element " + (lastIndex+1) + ":\t" + products[lastIndex].getClass() + "\t" + compType + ": " + getSortVal(products[lastIndex], compType));
		}
			System.out.println(sortAlg + " run time was: " + totalTime + " milliseconds");
		


	}
	
	public static double getSortVal(Product product, String compType) {
		switch (compType) {
			case "Original Price":
				return product.getOriginalPrice();
			case "Updated Price":
				return product.getUpdatedPrice();
			case "Real Difference":
				return product.calcRealDiff();
			default:
				System.out.println("Invalid comparison type when getting value");
				return -1;
		}
	}

}
