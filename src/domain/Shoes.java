package domain;
/**
 * Shoes product, using an adjustment of 0.3 for calculating the real difference
 */
public class Shoes extends Product{
	/**
	 * Creates a shoes product
	 * @param origPrice The original price
	 * @param updPrice The updated price
	 */
	public Shoes(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}
	/**
	 * Calculates real difference for shoes with adjustment of 0.3
	 * @return the real difference price
	 */
	@Override
	public double calcRealDiff() {

		return 0.3*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
