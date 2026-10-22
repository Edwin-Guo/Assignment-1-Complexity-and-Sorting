package external;

import java.util.Comparator;

import domain.Product;

public class UpdatedPriceCompare implements Comparator<Product>{

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
