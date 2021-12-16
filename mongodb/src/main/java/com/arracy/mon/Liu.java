package com.arracy.mon;

import java.util.HashMap;

public class Liu implements Cloneable {

    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        String sfs = (String) objectObjectHashMap.get("sfs");

        System.out.println(sfs);
    }
}
