package appDomain;

import java.util.Comparator;
import external.*;
import utilities.*;
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
	 *  
	 *  @author Edwin Guo
	 *  With editing from 
	 *  @author Zamira Jordan
	 */
	public static void main( String[] args )
	{
		/**
		 * comp - Used to provide the comparator to the sort methods
		 * compType - Used primarily for storing the compare type recieved from arguments, 
		 * "empty" by default to pass in null as comparator when wanting to use toCompare.
		 * sortAlg - Stores the sorting algorithm type received from arguments
		 * file - Stores the file directory provided by arguments
		 * products - Holds the array of products retrieved from the file.
		 * 
		 * initialTime - Used to get the initial time before starting the sorting algorithm
		 * totalTime - Used to calculate the time taken for the sorting algorihm
		 * 
		 * compType, sortAlg get reused for formatting print statements on the comparison type used and sorting algorithm used respectively.
		 */
		Comparator<Product> comp;
		String compType = "empty";
		String sortAlg = null;
		String file = null;
		Product[] products;
		
		long initialTime;
		long totalTime;
		// Checks to make sure there are three arguments provided, if not it stops the program
		if (args.length < 3 || args.length > 3) {
			System.out.println("Insufficient parameter count provided for the program to run smoothly.");
			System.out.println("The following is required: \"-f<file_name> -t<compare_type> -s<sort_alg>\"");
			return;
		} else {
			for (int i = 0; i < args.length; i++) {
				// Gets the option type, ignores cases
				// Then reads whatever comes after the option as the info provided
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
		// Ensures that the arguments had the correct input options, otherwise stops the program
		if (compType.equals("empty") || sortAlg == null || file == null) {
			System.out.println("An argument is missing, please provide \"-f<file_name> -t<compare_type> -s<sort_alg>\"");
			return;
		}
		// Converts the file provided to an array, stops program if file had nothing.
		products = ReadData.readData(file);
		if (products == null) {
			return;
		}
		// Checks the compare type provided by the arguments, and assigns the specified compare type. Stops program if invalid option
		// Null for real difference to use the default compareTo.
		// Changes the compType for printing purposes
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
		// Checks the provided argument sorting algorithm request, stops program if invalid choice is selected.
		// Changes the sortAlg for printing purposes, and also gets the time taken exclusively for the sort
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
				SelectionSort.sort(products, comp);
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
		// inc is used to change the increment value based on the size of the array
		int inc = 0;
		int lastIndex = products.length-1;
		if(products.length <= 10) {
			inc = 1;
		} else if (products.length <= 1000) {
			inc = 100;
		} else {
			inc = 1000;
		}
		// Guarantees the first element gets printed
		System.out.println("Element 1:\t" + products[0].getClass() + "\t" + compType + ": " + getSortVal(products[0], compType));
		if (inc == 1) {
			// Used to print every element in the array when less than 10 items
			for (int i = 1; i < products.length; i++) {
				System.out.println( "Element " + (i+1) +":\t" + products[i].getClass() + "\t" + compType + ": " + getSortVal(products[i], compType));
			}
		} else {
			for (int i = inc; i < products.length; i+=inc) {
				System.out.println( "Element " + i +":\t" + products[i].getClass() + "\t" + compType + ": " + getSortVal(products[i], compType));
			}
			// Guarantees the last element gets printed
			System.out.println("Element " + (lastIndex+1) + ":\t" + products[lastIndex].getClass() + "\t" + compType + ": " + getSortVal(products[lastIndex], compType));
		}
			System.out.println(sortAlg + " run time was: " + totalTime + " milliseconds");
		


	}
	/**
	 * Gets the price that is needed based on the comparison type used
	 * @param product The object that needs to get the price of for
	 * @param compType The comparison type that was used for the sorting
	 * @return the price of the product based on the comparison type
	 */
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
