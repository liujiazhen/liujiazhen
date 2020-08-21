package com.liujiazhen.http.client;

import java.math.BigDecimal;
import java.text.Format;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
//        test1();
        test2("399");
        String[] strings = new String[12];
        // 399.3
        // {"","","","","","","￥","3","9","9","3","0"}

        // 399
        // {"","","","","","","￥","3","9","9","0","0"}

        // 399.11
        // {"","","","","","","￥","3","9","9","1","1"}
    }

    static void test2(String s) {
        Double value = Double.valueOf(s);
        String s1 = "￥" + String.format("%.2f", value);
        StringBuilder strNumber = new StringBuilder(s1.replace(".", "")).reverse();
        String[] bit = new String[12];
        for (int i = 0; i < strNumber.length(); i++) {
            bit[i] = String.valueOf(strNumber.charAt(i));
        }
        for (int i = 0; i < bit.length; i++) {
            System.out.println(bit[i]);
        }

    }
// 为各个位做准备
    // 转为人民币大写
    private static void test1() {
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


        String dateString = "20200101";

        String s2 = dateString.substring(0, 4) + "-" + dateString.substring(4, 6) + "-" + dateString.substring(6, 8);
        System.out.println(s2);

        String doubleString = "223532.53";
        char[] chars = doubleString.toCharArray();
        String[] strs = new String[10];
        for (int x23 = 0; chars.length > x23; x23++) {
            if (chars[x23] == '.') {
                continue;
            }
            strs[x23] = String.valueOf(chars[x23]);
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]);
        }
    }
}