package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Nueva clase para el cálculo de precios
 * 
 */

public abstract class Price {
	
	/**
	 * Devuelve el código de precio asociado al tipo de película.
	 * 
	 * @return código de precio de la película.
	 */
	public abstract int getPriceCode();
	
	/**
	 * Calcula el importe del alquiler en función del número de días alquilados.
	 * Cada tipo de película implementará su propia regla de cálculo.
	 * 
	 * @param daysRented número de días de alquiler.
	 * @return importe calculado para el alquiler.
	 */
	public abstract double getCharge(int daysRented);

	/**
	 * Calcula los puntos frecuentes obtenidos por el alquiler.
	 * Por defecto, un alquiler genera un punto frecuente.
	 * Las clases hijas podrán sobrescribir este método si necesitan una regla diferente.
	 * 
	 * @param daysRented número de días de alquiler.
	 * @return puntos frecuentes obtenidos.
	 */	
	public int getFrequentRenterPoints(int daysRented) {
		int points = 1;
		// add bonus for a two day new release rental
		if ((this.getPriceCode() == NewReleasePrice.NEW_RELEASE) && daysRented > 1)
			points++;
		return points;
	}
}
