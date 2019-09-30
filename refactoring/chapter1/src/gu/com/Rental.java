package gu.com;

/**
 * @Auther: gu
 * @Date: 2019/5/17 20:06
 * @Description: TODO
 */
 class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(int _daysRented, Movie _movie) {
        daysRented = _daysRented;
        movie = _movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge(){
        return movie.getCharge(daysRented);
    }


}
