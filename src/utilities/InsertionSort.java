package utilities;

import java.util.Comparator;

import domain.Product;

public class InsertionSort {
	public static Product[] insertionSort(Product[] products, Comparator<Product> comp) {
		int length = products.length;
		for (int i = 1; i < length; i++) {
			Product key = products[i];
			int j = i - 1;
			while (j >= 0 && comp.compare(products[j], key) < 0) {
				products[j+1] = products[j];
				j--;
			}
			products[j+1] = key;
		}
		return products;
	}
}
