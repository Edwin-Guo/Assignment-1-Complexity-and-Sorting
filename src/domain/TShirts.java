package domain;

public class TShirts extends Product{

	public TShirts(double origPrice, double updPrice) {
		super(origPrice, updPrice);
		// TODO Auto-generated constructor stub
	}


	@Override
	public double calcRealDiff() {
		// TODO Auto-generated method stub
		return 0.4*Math.abs(getOriginalPrice()-getUpdatedPrice());
	}

}
