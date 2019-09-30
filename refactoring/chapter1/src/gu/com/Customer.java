package gu.com;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Auther: gu
 * @Date: 2019/5/17 20:10
 * @Description: TODO
 */
public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String statement() {
//        double totalAmount = 0;//去除临时变量 为 getTotleCharge() 方法
//        int frequentRenterPoints = 0;//去除临时变量 为 getTotleFrequentRenterPoints()方法
        Enumeration rentals = _rentals.elements();
        String result = "租赁记录 " + get_name() + "\n";
        while (rentals.hasMoreElements()) {
//            double thisAmount = 0; 去掉临时变量
            Rental each = (Rental) rentals.nextElement();

//            thisAmount = each.getCharge();//抽取方法 去掉临时变量

            //frequentRenterPoints = each.getFrequentRenterPoints(); //getTotleFrequentRenterPoints()

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
//            totalAmount += each.getCharge(); //去掉临时变量
        }
        result += "欠款是" + String.valueOf( getTotleCharge() ) + "\n"; //去除临时变量 为 getTotleCharge() 方法
        result += "您赚取了" + String.valueOf(getTotleFrequentRenterPoints()) + "租赁积金";
        return result;
    }

    private double getTotleFrequentRenterPoints(){  // frequentRenterPoints 常量提取为函数
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private double getTotleCharge(){  //totalAmount常量提取为函数
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    public static void main(String[] args) {
        Customer asd = new Customer("阿瑟东");
        Rental rental = new Rental(3, new Movie("g", 2));
        Rental renta2 = new Rental(3, new Movie("黑客帝国2", 0));
        Rental renta3 = new Rental(3, new Movie("黑客帝国3", 1));
        asd.addRental(rental);
        asd.addRental(renta2);
        asd.addRental(renta3);
        String statement = asd.statement();
        System.out.println(statement);
    }


}
