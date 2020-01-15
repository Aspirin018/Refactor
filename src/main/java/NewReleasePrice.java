public class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRented){
        return daysRented * 3;
    }

    int getFrequentRentalPoints(int daysRented) {
            return daysRented > 1 ? 2 : 1;
    }
}
