package com.cloudwalker.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaReflection {
    public static void main(String args[]) throws Exception {
        Cat myCat = new Cat("Kitty",6);
        //Fields using Reflection
        Field[] catFields = myCat.getClass().getDeclaredFields();

        for (Field field : catFields){
            System.out.println("Fields : "+field.getName());
        }

        for (Field field : catFields){
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(myCat,"Chikku");
            }
        }

        System.out.println(myCat.getName());
        //Methods using Reflection
        Method[] catMethods = myCat.getClass().getDeclaredMethods();

        for(Method method : catMethods){
            System.out.println("Methods : "+method.getName());
        }

        for(Method method : catMethods){
            if(method.getName().equals("heyThisIsPrivate")){
                method.setAccessible(true);
                method.invoke(myCat);
            }
            if(method.getName().equals("thisIsAPublicStaticMethod")){
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }
}
