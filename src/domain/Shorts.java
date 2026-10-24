package domain;
/**
 * Shorts product, using an adjustment of 0.3 for calculating the real difference
 */
public class Shorts extends Product{
	/**
	 * Creates a shorts product
	 * @param origPrice The original price
	 * @param updPrice The updated price
	 */
	public Shorts(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}
	/**
	 * Calculates real difference for shorts with adjustment of 0.3
	 * @return the real difference price
	 */
	@Override
	public double calcRealDiff() {
		return 0.3*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
