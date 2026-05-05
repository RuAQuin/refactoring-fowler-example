package ubu.gii.dass.refactoring;

public class NewReleasePrice extends Price {

	public static final int NEW_RELEASE = 1;

	@Override
	public int getPriceCode() {
		return NewReleasePrice.NEW_RELEASE;
	}

	@Override
	public double getCharge(int daysRented) {
		// TODO Auto-generated method stub
		return 0;
	}

}
