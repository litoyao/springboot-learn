package com.example.demo;

import com.example.demo.model.User;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            return unsafe;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Unsafe unsafe = getUnsafe();

        User user = new User();
        user.setName("xiao");
        long offset = unsafe.objectFieldOffset(user.getClass().getDeclaredField("age"));

        System.out.println(offset);
    }
}
