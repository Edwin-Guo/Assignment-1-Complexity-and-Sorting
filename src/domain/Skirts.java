package domain;
/**
 * Skirts product, using an adjustment of 0.1 for calculating the real difference
 */
public class Skirts extends Product {
	/**
	 * Creates a skirts product
	 * @param origPrice The original price
	 * @param updPrice The updated price
	 */
	public Skirts(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}
	/**
	 * Calculates real difference for skirts with adjustment of 0.1
	 * @return the real difference price
	 */
	@Override
	public double calcRealDiff() {
		return 0.1*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
