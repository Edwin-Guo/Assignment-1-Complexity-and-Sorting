package utilities;

import java.util.Comparator;

import domain.Product;
/**
 * An insertion sort algorithm that takes in Product arrays and the desired comparison type
 * @author Edwin Guo
 */
public class InsertionSort {
	/**
	 * Sorts the provided Product array using insertion sort, and comparing based on the provided compare type
	 * @param products The array that gets sorted
	 * @param comp The comparison type that gets used
	 */
	public static void sort(Product[] products, Comparator<Product> comp) {
		// Assumes the first element is always sorted 
		for (int i = 1; i < products.length; i++) {
			// The key is the element that gets compared with the sorted portion of the array
			Product key = products[i];
			// The index of the item before the key, last element in sorted section
			int j = i - 1;
			// Compares the sorted section with the key and shifts it to the right as needed
			while (j >= 0 && compare(products[j], key, comp) < 0) {
				products[j+1] = products[j];
				j--;
			}
			// Moves the key into the gap left by the shift
			products[j+1] = key;
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
