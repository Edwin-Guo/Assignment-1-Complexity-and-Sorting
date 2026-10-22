package domain;

public abstract class Product implements Comparable<Product> {
	private double originalPrice;
	private double updatedPrice;
	
	public Product (double origPrice, double updPrice) {
		originalPrice = origPrice;
		updatedPrice = updPrice;
		
	}
	public double getOriginalPrice() { 
		return originalPrice;
	}
	public double getUpdatedPrice() {
		return updatedPrice;
	}
	
	public abstract double calcRealDiff();
	
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
