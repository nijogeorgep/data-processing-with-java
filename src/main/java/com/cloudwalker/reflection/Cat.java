package com.cloudwalker.reflection;

public class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void meow(){
        System.out.println("Meow...Meow...");
    }

    private void heyThisIsPrivate(){
        System.out.println("How did you call this?..");
    }

    public static void thisIsAPublicStaticMethod(){
        System.out.println("I'm Public and Static");
    }

    private static void thisIsAPrivateStaticMethod(){
        System.out.println("I'm Private and Static");
    }
}
