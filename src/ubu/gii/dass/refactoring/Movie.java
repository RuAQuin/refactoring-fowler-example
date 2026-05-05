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
	private String _title;
	private Price _price;

	public Movie(String title, Price price) {
		_title = title;
		_price = price;
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPrice(Price arg) {
		_price = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {
		double rentalCharge = 0;
	
		switch (this.getPriceCode()) {
		case RegularPrice.REGULAR:
			rentalCharge += 2;
			if (daysRented > 2)
				rentalCharge += (daysRented - 2) * 1.5;
			break;
		case NewReleasePrice.NEW_RELEASE:
			rentalCharge += daysRented * 3;
			break;
		case ChildrensPrice.CHILDRENS:
			rentalCharge += 1.5;
			if (daysRented > 3)
				rentalCharge += (daysRented - 3) * 1.5;
			break;
		}
		return rentalCharge;
	}

	public int getFrequentRenterPoints(int daysRented) {
		int points = 1;
		// add bonus for a two day new release rental
		if ((getPriceCode() == NewReleasePrice.NEW_RELEASE) && daysRented > 1)
			points++;
		return points;
	}
}
