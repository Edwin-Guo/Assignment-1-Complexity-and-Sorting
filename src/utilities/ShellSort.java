
package utilities;

import java.util.Comparator;
import domain.Product;

/**
 * Implements the Shell Sort algorithm for Product objects.
 * <p>
 * Sorts products in descending order by comparing and shifting
 * elements using decreasing gaps.
 * </p>
 */
public class ShellSort {

    /**
     * Sorts products in descending order using a Comparator.
     *
     * @param products the array of products to sort
     * @param comparator the comparator used to compare products
     */
    public static void sort(Product[] products,
                            Comparator<Product> comparator) {

        int n = products.length;

        // Start with half the array size and reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Product temp = products[i];
                int j = i;

                // Shift smaller products to the right
                while (j >= gap &&
                       compare(products[j - gap], temp, comparator) < 0) {

                    products[j] = products[j - gap];
                    j -= gap;
                }

                products[j] = temp;
            }
        }
    }

    /**
     * Sorts products in descending order using Comparable.
     * Products are compared using their natural ordering.
     *
     * @param products the array of products to sort
     */
    public static void sort(Product[] products) {

        int n = products.length;

        // Start with half the array size and reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Product temp = products[i];
                int j = i;

                // Shift smaller products to the right
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
     * Compares two products using the provided Comparator.
     * If no Comparator is given, the natural ordering is used.
     *
     * @param a the first product
     * @param b the second product
     * @param comparator the comparator used for comparison
     * @return a negative, zero, or positive value based on comparison
     */
    private static int compare(Product a, Product b,
                               Comparator<Product> comparator) {

        if (comparator == null) {
            return a.compareTo(b);
        }

        return comparator.compare(a, b);
    }
}



