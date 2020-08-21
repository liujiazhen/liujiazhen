package org.liujiazhen.test;

public class SpringbootTest {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        String ss = "/D:/user/springboot/WEB-INFO/class";

        String substring = ss.substring(0, ss.indexOf("WEB-INFO"));
        System.out.println(substring);
    }
}
