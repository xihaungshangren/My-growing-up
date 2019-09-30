package gu.com;

/**
 * @Auther: gu
 * @Date: 2019/5/17 20:06
 * @Description: TODO
 */
public class Movie {
    public static final int CHILDNS = 2;
    public static final int REGULAR=0;
    public static final int NEW_RELEASE=1;

    private String _title;
    private Price price;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        setPriceCode(_priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg){
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDNS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("票类型不正确");
        }
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
