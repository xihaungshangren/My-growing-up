package gu.com;

/**
 * @Auther: gu
 * @Date: 2019/5/22 20:34
 * @Description: TODO
 */
public class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDNS;
    }
    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
