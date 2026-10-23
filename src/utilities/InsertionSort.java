package utilities;

import java.util.Comparator;

import domain.Product;

public class InsertionSort {
	public static void sort(Product[] products, Comparator<Product> comp) {
		int length = products.length;
		for (int i = 1; i < length; i++) {
			Product key = products[i];
			int j = i - 1;
			while (j >= 0 && compare(products[j], key, comp) < 0) {
				products[j+1] = products[j];
				j--;
			}
			products[j+1] = key;
		}
	}
	
    private static int compare(Product a, Product b, Comparator<Product> comparator) {
        if (comparator == null) {
            return a.compareTo(b);
        }
        return comparator.compare(a, b);
    }
}
