package gu.com;

/**
 * @Auther: gu
 * @Date: 2019/5/22 20:35
 * @Description: TODO
 */
public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }


}
