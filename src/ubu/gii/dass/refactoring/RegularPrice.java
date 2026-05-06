package ubu.gii.dass.refactoring;

public class RegularPrice extends Price {

	public static final int REGULAR = 0;

	@Override
	public int getPriceCode() {
		return RegularPrice.REGULAR;
	}

	@Override
	public double getCharge(int daysRented) {
		double rentalCharge = 2;
		if (daysRented > 2)
			rentalCharge += (daysRented - 2) * 1.5;
		return rentalCharge;
	}

}
