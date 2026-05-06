package ubu.gii.dass.refactoring;

public class ChildrensPrice extends Price {

	public static final int CHILDRENS = 2;

	@Override
	public int getPriceCode() {
		return ChildrensPrice.CHILDRENS;
	}

	@Override
	public double getCharge(int daysRented) {
		double rentalCharge = 1.5;
		if (daysRented > 3)
			rentalCharge += (daysRented - 3) * 1.5;
		return rentalCharge;
	}

}
