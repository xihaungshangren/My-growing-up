package gu;

import net.jcip.annotations.NotThreadSafe;

import java.util.concurrent.atomic.AtomicLong;

@NotThreadSafe
public class MyUnsafe {
    private int value;
    AtomicLong count ;
    public int getNext(){
        return value++;
    }
}
