package gu.com.Move_Method;
 class Account {
    private AccountType type;
    private int daysOverdrawn;

//1.0
//    double overdraftCharge() {
//        if (type.isPremium()) {
//            double result = 10;
//            if (daysOverdrawn > 7) return result += (daysOverdrawn - 7) * 0.85;
//            return result;
//        } else {
//            return daysOverdrawn * 1.75;
//        }
//    }//end overdraftCharge()

//    /**
//     * Move Method 后考虑是否删除源函数，这里删除的做法
//     * @return
//     */
//    double overdraftCharge(){
//        return type.overdraftCharge(daysOverdrawn);
//    }


    double bankCharge(){
        double result = 4.5;
        if (daysOverdrawn>0) result +=type.overdraftCharge(daysOverdrawn);
        return result;
    }


}
