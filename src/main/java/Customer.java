import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental){
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        int frequentRentPoints = 0;
        Enumeration allRentals = rentals.elements();
        String result = "Rental records for " + getName() + "\n";
        while(allRentals.hasMoreElements()){
            Rental each = (Rental) allRentals.nextElement();
            frequentRentPoints += getFrequentRentalPoints(each);
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        result += "Amount owned is " + getTotalCharge() + ".\n";
        result += "You earned " + frequentRentPoints + " frequent rental points.";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration allRentals = rentals.elements();
        while(allRentals.hasMoreElements()){
            Rental each = (Rental) allRentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getFrequentRentalPoints(Rental aRental){
        if(aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE &&
                aRental.getDaysRented() > 1){
            return 2;
        }
        return 1;
    }
}
