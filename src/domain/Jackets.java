package domain;
/**
 * Jackets product, using an adjustment of 0.7 for calculating the real difference
 */
public class Jackets extends Product {
	/**
	 * Creates a jackets product
	 * @param origPrice The original price
	 * @param updPrice The updated price
	 */
	public Jackets(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}
	/**
	 * Calculates real difference for jackets with adjustment of 0.7
	 * @return the real difference price
	 */
	@Override
	public double calcRealDiff() {
		return 0.7*Math.abs(getOriginalPrice()-getUpdatedPrice());

	}

}
