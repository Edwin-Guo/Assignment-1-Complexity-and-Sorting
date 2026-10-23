package utilities;

import java.util.Comparator;
import domain.Product;

/**
 * 
 * BubbleSort sorts objects from largest to smallest using bubble sort
 * 
 * @author Adrianne Shean Pacifico
 */
public class BubbleSort {
    /**
     * this sorts products using compareTo() (calculated difference)
     * 
     * @param products the array to sort
     */
    public static void sort(Product[] products) {
        sort(products, null);
    }

    /**
     * sorts products using a comparator (original or updated price)
     * if the comparator is null, compareTo() will be used instead
     * 
     * @param products   the array to sort
     * @param comparator how to compare two products, or null for compareTo()
     */
    public static void sort(Product[] products, Comparator<Product> comparator) {
        // nothing to sort if there is no array
        if (products == null) {
            return;
        }
        // nothing to sort if there are less than 2 items
        if (products.length < 2) {
            return;
        }

        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - 1 - i; j++) {
                // if the left item is smaller, switch them so the larger one comes first
                if (compare(products[j], products[j + 1], comparator) < 0) {
                    Product tempProduct = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = tempProduct;
                }
            }
        }
    }

    /**
     * this compares two products with the comparator or with compareTo() if its
     * null
     * 
     * @param a          first product
     * @param b          second product
     * @param comparator how to compare two products, or null for compareTo()
     * @return a negative number, zero, or a positive number if a is less than,
     *         greater than, or equal to b
     */
    private static int compare(Product a, Product b, Comparator<Product> comparator) {
        if (comparator == null) {
            return a.compareTo(b);
        }
        return comparator.compare(a, b);
    }
}
