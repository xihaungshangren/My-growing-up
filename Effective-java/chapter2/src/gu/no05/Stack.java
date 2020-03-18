package gu.no05;

import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;

    //栈
    public Stack(int initials){
        this.elements = new Object[initials];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
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
