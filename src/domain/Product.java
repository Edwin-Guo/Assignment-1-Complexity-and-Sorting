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
	 * Each product has their own real difference formula requiring them to make it
	 * @return
	 */
	public abstract double calcRealDiff();
	
	/**
	 * @param that The product that it compares the RealDiff values of
	 * @return The result of the comparison 
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
