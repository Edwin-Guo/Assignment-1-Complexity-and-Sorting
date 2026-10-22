package domain;

public class Dress extends Product {

	public Dress(double origPrice, double updPrice) {
		super(origPrice, updPrice);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double calcRealDiff() {
		// TODO Auto-generated method stub
		return 0.6*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
