package gu.com;

/**
 * @Auther: gu
 * @Date: 2019/5/22 20:35
 * @Description: TODO
 */
public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    double getCharge(int daysRented) {
        return daysRented * 3;
    }
    int getFrequentRenterPoints(int daysRented) {
        return (daysRented>1) ? 2 : 1;
    }
}
