package domain;

public class Jacket extends Product {

	public Jacket(double origPrice, double updPrice) {
		super(origPrice, updPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcRealDiff() {
		// TODO Auto-generated method stub
		return 0.7*Math.abs(getOriginalPrice()-getUpdatedPrice());

	}

}
