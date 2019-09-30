package gu.com;

public class Test {
    public static void main(String[] args) {
        System.out.println("df");
        Customer customer = new Customer("伟反倒是");
        customer.addRental(new Rental(2,new Movie("黑客帝国",1)));
        System.out.println(customer.statement());
    }
}
