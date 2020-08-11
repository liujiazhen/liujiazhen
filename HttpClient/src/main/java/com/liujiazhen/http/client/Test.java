package com.liujiazhen.http.client;

import java.math.BigDecimal;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        System.out.println('は');
        System.out.println('b');
        int x = 'a'^'b';
        String s = Integer.toBinaryString(x);
        System.out.println(s);
        int t = 0x1111001;
        System.out.println(t);
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        double x3 = 22.3;
        BigDecimal bigDecimal = new BigDecimal("22.33");
        String s1 = bigDecimal.toString();
        System.out.println(s1);

        String s23  = "";

    }
}