package external;

import java.util.Comparator;

import domain.Product;
/**
 * Compares the prices of the products based on their updated prices using Comparator
 * @author Edwin Guo
 */
public class UpdatedPriceCompare implements Comparator<Product>{
	/**
	 * Compares product classes's updated prices 
	 * @param p1 The first product to compare with
	 * @param p2 The second product to compare with
	 * @return 1 if p1 is larger, -1 if p1 is smaller, 0 if equal
	 */
	@Override
	public int compare(Product p1, Product p2) {
		if (p1.getUpdatedPrice() > p2.getUpdatedPrice()) {
			return 1;
		} else if (p1.getUpdatedPrice() < p2.getUpdatedPrice()) {
			return -1;
		} else {
			return 0;
		}
	}

}
