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
        double totalAmount = 0;
        int frequentRentPoints = 0;
        Enumeration allRentals = rentals.elements();
        String result = "Rental records for " + getName() + "\n";
        while(allRentals.hasMoreElements()){
            Rental each = (Rental) allRentals.nextElement();
            double thisAmount = each.getCharge();
            frequentRentPoints ++;
            if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE &&
            each.getDaysRented() > 1){
                frequentRentPoints ++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owned is " + totalAmount + ".\n";
        result += "You earned " + frequentRentPoints + " frequent rental points.";
        return result;
    }
}
