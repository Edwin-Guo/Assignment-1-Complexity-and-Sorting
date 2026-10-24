package domain;
/**
 * Dresses product, using an adjustment of 0.6 for calculating the real difference
 */
public class Dresses extends Product {
	/**
	 * Creates a dresses product
	 * @param origPrice The original price
	 * @param updPrice The updated price
	 */
	public Dresses(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}
	/**
	 * Calculates real difference for dresses with adjustment of 0.6
	 * @return the real difference price
	 */
	@Override
	public double calcRealDiff() {
		return 0.6*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
