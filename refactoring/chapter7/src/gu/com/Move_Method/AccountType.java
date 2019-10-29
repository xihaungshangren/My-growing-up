package gu.com.Move_Method;

class AccountType {
    public boolean isPremium() {
        return false;
    }

    /**
     * 搬移函数：
     * 原因：一个类的方法有与其他类有太多的耦合。
     * 关键点：源类的特性处理，与源类相关的参数，函数以什么形式传递到目标类中。（源类的对象传入，做一个参数传入，将源类的
     * 特性传入）
     * @param daysOverdrawn
     * @return
     */
    double overdraftCharge(int daysOverdrawn) {
        if (isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7) return result += (daysOverdrawn - 7) * 0.85;
            return result;
        } else {
            return daysOverdrawn * 1.75;
        }
    }//end overdraftCharge()
}
