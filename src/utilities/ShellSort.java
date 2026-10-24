
package utilities;

import java.util.Comparator;
import domain.Product;

//Sorting product array using the Shellsort Algorithm.
public class ShellSort {

    /**
     * @param products array contains the elements.
     * @param comparator is used to compare the elements.
     */
    public static void sort(Product[] products,
                            Comparator<Product> comparator) {

        int n = products.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Product temp = products[i];
                int j = i;

                // Move smaller values to the right
                while (j >= gap &&
                       compare(products[j - gap], temp, comparator) < 0) {

                    products[j] = products[j - gap];
                    j -= gap;
                }

                products[j] = temp;
            }
        }
    }

    // Shell Sort using Comparable
    public static void sort(Product[] products) {

        int n = products.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Product temp = products[i];
                int j = i;

                // Move smaller values to the right
                while (j >= gap &&
                       products[j - gap].compareTo(temp) < 0) {

                    products[j] = products[j - gap];
                    j -= gap;
                }

                products[j] = temp;
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

