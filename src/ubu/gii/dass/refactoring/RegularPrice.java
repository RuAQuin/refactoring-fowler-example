package ubu.gii.dass.refactoring;

public class RegularPrice extends Price {

	public static final int REGULAR = 0;

	@Override
	public int getPriceCode() {
		return RegularPrice.REGULAR;
	}

	@Override
	public double getCharge(int daysRented) {
		// TODO Auto-generated method stub
		return 0;
	}

}
