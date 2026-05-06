package ubu.gii.dass.refactoring;

public class NewReleasePrice extends Price {

	public static final int NEW_RELEASE = 1;

	@Override
	public int getPriceCode() {
		return NewReleasePrice.NEW_RELEASE;
	}

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented){
		return (daysRented > 1) ? 2 : 1;
	}
}
