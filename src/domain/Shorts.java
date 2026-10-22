package domain;

public class Shorts extends Product{

	public Shorts(double origPrice, double updPrice) {
		super(origPrice, updPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcRealDiff() {
		// TODO Auto-generated method stub
		return 0.3*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
