
public class Runner {
    public static void main(String[] args) {
        Movie childrenMovie = new Movie("children movie", 2);
        Movie regularMovie = new Movie("regular movie", 0);
        Movie newReleaseMovie = new Movie("new release movie", 1);
        Rental childrenRental = new Rental(childrenMovie, 3);
        Rental regularRental = new Rental(regularMovie, 3);
        Rental newReleaseRental = new Rental(newReleaseMovie, 3);
        Customer customer = new Customer("me");
        customer.addRental(childrenRental);
        customer.addRental(regularRental);
        customer.addRental(newReleaseRental);
        String statement = customer.statement();
        System.out.println(statement);
    }
}
