package gu.no02;

public class Elvis {

    public static final Elvis Instance = new Elvis();
    private Elvis(){
        System.out.println("Elvis");
    }
}
