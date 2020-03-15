package com.example.demo;

public class StringTest {

    public static void main(String[] args) {

        String s1=new String("a");
        String s2=new String("a");
        String s3="a";

        System.out.println(s2 == s1);
        System.out.println(s3 == s1);

        String a = "job";
        String aa = "job";
        String b = "high-job";
        String c = "j" + "o" + "b";

        System.out.println(a == aa);
        System.out.println(a == b.substring(5));
        System.out.println(a == c);

        System.out.println("--------------------");
        User u1 = new User("name", "add1");
        User u11 = new User("name", "add1");

        System.out.println(u1.getName()==u11.getName());
        System.out.println(u1==u11);

    }

    static class User {
        String name;
        String address;
        int age;

        public User(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
