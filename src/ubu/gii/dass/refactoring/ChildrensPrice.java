package ubu.gii.dass.refactoring;

public class ChildrensPrice extends Price {

	public static final int CHILDRENS = 2;

	@Override
	public int getPriceCode() {
		return ChildrensPrice.CHILDRENS;
	}

	@Override
	public double getCharge(int daysRented) {
		// TODO Auto-generated method stub
		return 0;
	}

}
