package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			// determine amounts for each line
			double thisAmount = each.getCharge();
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
		}
		// Se añaden los totales reutilizando métodos comunes para evitar duplicación.
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	public String htmlStatement() {
	    Iterator<Rental> rentals = _rentals.iterator();
	    String result = "<H1>Rental Record for " + getName() + "</H1>";
	while (rentals.hasNext()) {
	    Rental each = rentals.next();
	    // determine amounts for each line
	double thisAmount = each.getCharge();
	// show figures for this rental
	result += "<H2>" + each.getMovie().getTitle() + " " + String.valueOf(thisAmount) + "</H2>";
	}
	// Se añaden los totales reutilizando métodos comunes para evitar duplicación.
	result += "<P>Amount owed is " + String.valueOf(getTotalCharge()) + "</P>";
	result += "<P> You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points </P>";
	    return result;
	}

	private double getTotalCharge() {
	    double result = 0;
	    Iterator<Rental> rentals = _rentals.iterator();
	    while (rentals.hasNext()) {
	        Rental each = rentals.next();
	        // Se acumula el importe de cada alquiler.
	        result += each.getCharge();
	    }
	    return result;
	}

	private int getTotalFrequentRenterPoints() {
	    int result = 0;
	    Iterator<Rental> rentals = _rentals.iterator();
	    while (rentals.hasNext()) {
	        Rental each = rentals.next();
	        // Se acumulan los puntos frecuentes calculados por cada alquiler.
	        result += each.getFrequentRenterPoints();
	    }
	    return result;
	}	
}
