package utilities;

import java.util.Comparator;
import domain.Product;

/**
 * 
 * MergeSort class sorts objects from largest to smallest using merge sort
 * 
 * @author Adrianne Shean Pacifico
 */
public class MergeSort {

    /**
     * sorts products using compareTo() (calculated difference)
     * 
     * @param products is the array to sort
     */
    public static void sort(Product[] products) {
        sort(products, null);
    }

    /**
     * this sorts products using comparator (original or updated price)
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
        // no sorting if there are less than 2 items
        if (products.length < 2) {
            return;
        }
        // extra array is used here for merging
        Product[] helper = new Product[products.length];
        mergeSort(products, helper, 0, products.length - 1, comparator);
    }

    /**
     * splits the array in half, sorts each half, and then merges them
     * 
     * @param products   the array being sorted
     * @param helper     extra array used for merging
     * @param left       first index of this section
     * @param right      last index of this section
     * @param comparator how to compare two products, or null for compareTo()
     */
    private static void mergeSort(Product[] products, Product[] helper, int left, int right,
            Comparator<Product> comparator) {
        // one element or less is already sorted
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(products, helper, left, middle, comparator); // this sorts the left half
        mergeSort(products, helper, middle + 1, right, comparator); // this sorts the right half
        merge(products, helper, left, middle, right, comparator); // this combines both sorted half
    }

    /**
     * combines two sorted half into one and largest is first
     * 
     * @param products   the array being used
     * @param helper     extra array used for merging
     * @param left       first index of the left half
     * @param middle     last index of the left half
     * @param right      last index of the right half
     * @param comparator how to compare two products, or null for compareTo()
     */
    private static void merge(Product[] products, Product[] helper, int left, int middle, int right,
            Comparator<Product> comparator) {
        int i = left; // left position
        int j = middle + 1; // right position
        int k = left; // the helper position

        // take the larger element in the front each iteration
        while (i <= middle && j <= right) {
            if (compare(products[i], products[j], comparator) >= 0) {
                helper[k++] = products[i++];
            } else {
                helper[k++] = products[j++];
            }
        }
        // this copies what is left in the left half
        while (i <= middle) {
            helper[k++] = products[i++];
        }
        // copies the leftovers in the right half
        while (j <= right) {
            helper[k++] = products[j++];
        }
        // copies the result back to the original array
        for (int x = left; x <= right; x++) {
            products[x] = helper[x];
        }
    }

    /**
     * this compares two products with the comparator
     * with compareTo() if its null
     * 
     * @param a          the first product
     * @param b          the second product
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
