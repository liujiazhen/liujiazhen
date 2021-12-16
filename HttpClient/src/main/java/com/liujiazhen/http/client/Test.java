package com.liujiazhen.http.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.Format;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Test {
    static class Student{
        private String name;
        private String age;
        private Date date;
        public Student(String name, String age) {
            this.name = name;
            this.age = age;
        }

    }

    public static void main(String[] args) {
        Teacher2 liu = new Teacher2();
        liu.setName("22");
        liu.setDate(LocalDate.now());
        String s = JSON.toJSONString(liu);

        System.out.println(s);



        JSONObject jsonObject = JSONObject.parseObject(s);
        Teacher2 teacher = JSONObject.toJavaObject(jsonObject, Teacher2.class);
        System.out.println(teacher);


    }

    public static boolean maxMin30NumbericText(String src) {
        if (src == null) {
            return true;
        } else {
            for (int i = src.length(); --i >= 0; ) {
                int chr = src.charAt(i);
                if (chr < 48 || chr > 57) {
                    return false;
                }
            }
            return src.length() == 30;
        }
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
class Teacher{
    private String name;
    private Date date;

    public Teacher() {
    }

    public Teacher(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

class Teacher2{
    private String name;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Teacher2{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}