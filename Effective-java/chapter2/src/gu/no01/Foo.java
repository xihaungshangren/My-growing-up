package gu.no01;

import java.util.HashMap;
import java.util.Map;

public class Foo {
    private static Map implementations = null;
    Object o;

    private static synchronized void initMapIfNecessary() {
        if (implementations == null) {
            implementations = new HashMap();
        }
    }

    public static Foo getInstance(String key) {
        initMapIfNecessary();
        Class c = (Class) implementations.get(key);
        if (c == null)
            return new Foo();
        try {
            return (Foo) c.newInstance();
        } catch (Exception e) {
            return new Foo();
        }

    }


}
