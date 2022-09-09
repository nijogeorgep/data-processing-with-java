package com.cloudwalker.annotations;

@VeryImportant
public class Animal {
    @ImportantString
    public String name;
    private int age;


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @RunImmediately(times=3)
    public void cry(){
        System.out.println("My Animal "+name+" is Crying");
    }

    @RunImmediately(times=1,repeat=5)
    public void eat(){
        System.out.println("My Animal "+name+" is Eating");
    }

}
