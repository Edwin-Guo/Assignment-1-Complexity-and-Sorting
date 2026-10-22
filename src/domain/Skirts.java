package domain;

public class Skirts extends Product {

	public Skirts(double origPrice, double updPrice) {
		super(origPrice, updPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcRealDiff() {
		// TODO Auto-generated method stub
		return 0.1*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
