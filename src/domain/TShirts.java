package domain;
/**
 * TShirts product, using an adjustment of 0.4 for calculating the real difference
 */
public class TShirts extends Product{
	/**
	 * Creates a tshirts product
	 * @param origPrice The original price
	 * @param updPrice The updated price
	 */
	public TShirts(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}

	/**
	 * Calculates real difference for tshirts with adjustment of 0.4
	 * @return the real difference price
	 */
	@Override
	public double calcRealDiff() {
		return 0.4*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
