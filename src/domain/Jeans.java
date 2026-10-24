package domain;
/**
 * Jeans product, using an adjustment of 0.5 for calculating the real difference
 */
public class Jeans extends Product{
	/**
	 * Creates a jeans product
	 * @param origPrice The original price
	 * @param updPrice The updated price
	 */
	public Jeans(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}
	/**
	 * Calculates real difference for jeans with adjustment of 0.5
	 * @return the real difference price
	 */
	@Override
	public double calcRealDiff() {
		return 0.5*Math.abs(getOriginalPrice()-getUpdatedPrice());

	}

}
