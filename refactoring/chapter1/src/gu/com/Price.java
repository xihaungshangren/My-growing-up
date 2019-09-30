package gu.com;

/**
 * @Auther: gu
 * @Date: 2019/5/22 20:33
 * @Description: TODO
 */
public abstract class Price {
    abstract int getPriceCode();
    //提炼价格计算的代码，抽取为方法，并对内部变量名修改 移动到 Movie 类中，switch的判断条件，用的是 Movie 类中的参数
    abstract double getCharge(int daysRented); //{
    //    double result = 0;
    //    switch (getPriceCode()) {
    //        case Movie.REGULAR:
    //            result += 2;
    //            if (daysRented > 2)
    //                result += (daysRented - 2) * 1.5;
    //            break;
    //        case Movie.NEW_RELEASE:
    //            result += daysRented * 3;
    //            break;
    //        case Movie.CHILDNS:
    //            result += 1.5;
    //            if (daysRented > 3)
    //                result += (daysRented - 3) * 1.5;
    //            break;
    //    }
    //    return result;
    //}

    //提炼常客积分计算的代码 移动到price
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
