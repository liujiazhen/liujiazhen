package org.liujiazhen.poi.util;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        Student zhangsan = new Student(1, "张三", "code1", "文件名字a");
        Student sfsd = new Student(2, "李斯特", "code2", "文件名字b");
        Student sfs = new Student(3, "张三", "code3", "文件名字c");

        ArrayList<Student> list = new ArrayList<>();
        list.add(zhangsan);
        list.add(sfsd);
        list.add(sfs);
//        System.out.println("原地址：" + zhangsan);
//        for (int i = 0; i < 2; i++) {
//            List<Student> collect = list.stream().filter(v -> "张三".equals(v.getName())).collect(Collectors.toList());
//            if (!collect.isEmpty()) {
//                Student student = collect.get(0);
//                System.out.println("过滤后的地址" + student);
//                list.remove(student);
//            }
//        }
//        System.out.println(list);
//
//        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getName));
//        System.out.println(collect);
//
//        BigDecimal bigDecimal = new BigDecimal("0");
//        List<String> list1 = new ArrayList<>();
//        Student aa = new Student(44, "aa");
//        String s = "aaaaaaaaaaaaa";
//        myFunction(bigDecimal, list1, aa, s);
//        System.out.println(bigDecimal);
//        System.out.println(list1);
//        System.out.println(aa);
//        System.out.println(s);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("aa","bb");
//        jsonObject.put("ab", aa);
//        System.out.println(jsonObject);
        Map<String, String> collect = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.mapping(v -> v.getCode() + v.getCodeName(), Collectors.joining(";"))));
        System.out.println(collect);
    }


    static void myFunction(BigDecimal bigDecimal, List<String> list, Student aa, String s) {
        bigDecimal = bigDecimal.add(BigDecimal.valueOf(22));
        list.add("fsd");
        aa.setName("bb");
        s = "fdsf";
    }
}

class Student {
    private Integer id;
    private String name;

    private String code;

    private String codeName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Integer id, String name, String code, String codeName) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.codeName = codeName;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
