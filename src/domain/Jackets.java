package domain;

public class Jackets extends Product {

	public Jackets(double origPrice, double updPrice) {
		super(origPrice, updPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcRealDiff() {
		// TODO Auto-generated method stub
		return 0.7*Math.abs(getOriginalPrice()-getUpdatedPrice());

	}

}
