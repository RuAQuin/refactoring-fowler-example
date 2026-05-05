package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(Rental rental, int daysRented) {
		double rentalCharge = 0;
	
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			rentalCharge += 2;
			if (daysRented > 2)
				rentalCharge += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			rentalCharge += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			rentalCharge += 1.5;
			if (daysRented > 3)
				rentalCharge += (daysRented - 3) * 1.5;
			break;
		}
		return rentalCharge;
	}

	public int getFrequentRenterPoints(Rental rental, int daysRented) {
		int points = 1;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			points++;
		return points;
	}
}
