
package utilities;

import java.util.Comparator;
import domain.Product;

public class ShellSort {

    // Shell Sort using Comparator
    public static void sort(Product[] products,
                            Comparator<Product> comparator) {

        int n = products.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Product temp = products[i];
                int j = i;

                // Move smaller values to the right
                while (j >= gap &&
                       comparator.compare(products[j - gap], temp) < 0) {

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
}

