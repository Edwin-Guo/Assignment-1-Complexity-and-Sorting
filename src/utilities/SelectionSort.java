package utilities;

import java.util.Comparator;

import domain.Product;
/**
 * A selection sort algorithm that takes in a product array and compares it based on the compare type provided
 * @author Edwin Guo
 */
public class SelectionSort {
	/**
	 * Sorts the products array based on the compare type using selection sort
	 * @param products The Product array that gets sorted 
	 * @param comp The comparison type that gets used
	 */
	public static void sort(Product[] products, Comparator<Product> comp) {
		// Retrieves the largest value found in the array, assumes the first is always the largest
		for (int i = 0; i < products.length-1; i++) {
			int maxIndex = i;
			// Runs through each number in the products not including the first one to see if it's larger than the first one
			for (int j = i+1; j < products.length; j++) {
				if (compare(products[maxIndex],products[j], comp) < 0){
					maxIndex = j;
				}
			}
			// Swaps the position of the largest left in the unsorted part of the array next to the next biggest in the array
			// Checks to see if it already is in the correct spit with the maxIndex!=1
			if (maxIndex != i) {
				Product temp = products[i];
				products[i] = products[maxIndex];
				products[maxIndex] = temp;
			}
		}
	}
	/**
	 * Checks to see if the comparator is provided, if not provided uses the default compareTo
	 * @param a The first product that gets compared to b with
	 * @param b The second product 
	 * @param comparator The compare type that is supposed to be used 
	 * @return The result of the compare
	 */
    private static int compare(Product a, Product b, Comparator<Product> comparator) {
        if (comparator == null) {
            return a.compareTo(b);
        }
        return comparator.compare(a, b);
    }
}
