package gu.com.Extract_Class;

class TelephoneNumber {
    private String areaCode;
    private String number;

    public String getTelephoneNumber() {
        return ( "(" + areaCode + ")" + this.number );
    }

    String getAreaCode() {
        return areaCode;
    }

    void setAreaCode(String arg) {
        this.areaCode = arg;
    }

    String getNumber() {
        return number;
    }

    void setNumber(String arg) {
        number = arg;
    }
}
