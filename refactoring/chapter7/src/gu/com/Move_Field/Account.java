package gu.com.Move_Field;

class Account {
    private AccountType type;
    private double interestRate;

    double interest(double amount, int days) {
        return type.getInterestRate() * amount * days / 365;
    }

    double getInterestRate() {
        return interestRate;
    }

    void setInterestRate(double arg) {
        this.interestRate = arg;
    }
}
