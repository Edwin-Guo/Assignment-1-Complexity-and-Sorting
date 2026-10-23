package utilities;

import java.util.Comparator;

import domain.Product;

public class SelectionSort {
	public static void sort(Product[] products, Comparator<Product> comp) {
		for (int i = 0; i < products.length-1; i++) {
			int maxIndex = i;
			for (int j = i+1; j < products.length; j++) {
				if (compare(products[maxIndex],products[j], comp) < 0){
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				Product temp = products[i];
				products[i] = products[maxIndex];
				products[maxIndex] = temp;
			}
		}
	}
	
    private static int compare(Product a, Product b, Comparator<Product> comparator) {
        if (comparator == null) {
            return a.compareTo(b);
        }
        return comparator.compare(a, b);
    }
}
