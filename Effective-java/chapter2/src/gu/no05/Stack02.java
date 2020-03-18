package gu.no05;

import java.util.EmptyStackException;

public class Stack02 {
    private Object[] elements;
    private int size = 0;

    //栈
    public Stack02(int initials){
        this.elements = new Object[initials];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    //确保
    private void ensureCapacity() {
        if (elements.length ==size){
            Object[] oldElemrnts = elements;
            elements = new Object[2 * elements.length+1];
            System.arraycopy(oldElemrnts,0,elements,0,size);
        }

    }

}
