package domain;

public class Jeans extends Product{

	public Jeans(double origPrice, double updPrice) {
		super(origPrice, updPrice);
	}
	
	@Override
	public double calcRealDiff() {
		// TODO Auto-generated method stub
		return 0.5*Math.abs(getOriginalPrice()-getUpdatedPrice());

	}

}
