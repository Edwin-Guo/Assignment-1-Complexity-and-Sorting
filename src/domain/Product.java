package domain;
/**
 * The base class used for each clothing product, containing the details original price and updated price provided.
 * Also includes how the products get compared by default with the RealDiff 
 * @author Edwin Guo
 */
public abstract class Product implements Comparable<Product> {
	private double originalPrice;
	private double updatedPrice;
	/**
	 * Used to create the object of the product
	 * @param origPrice Takes the original price of the product
	 * @param updPrice Takes the updated price of the product
	 */
	public Product (double origPrice, double updPrice) {
		originalPrice = origPrice;
		updatedPrice = updPrice;
		
	}
	/**
	 * @return The original price 
	 */
	public double getOriginalPrice() { 
		return originalPrice;
	}
	/**
	 * @return The updated price 
	 */
	public double getUpdatedPrice() {
		return updatedPrice;
	}
	/**
	 * The real price difference adjusted based on the product adjustment value provided by the subclass
	 * @return The real difference of the prices
	 */
	public abstract double calcRealDiff();
	
	/**
	 * Compares one product with another product based on their real difference
	 * @param that The product that it compares the RealDiff values of
	 * @return Positive if number is greater, negative is less, and zero if equal 
	 */
	public int compareTo(Product that) {
		if( this.calcRealDiff() > that.calcRealDiff())
		{
			return 1;
		}
		else if( this.calcRealDiff()< that.calcRealDiff() )
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
