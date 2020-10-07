package com.example.data;

import java.lang.ref.PhantomReference;

public class Account {
    private int id;
    private String name;
    private int math;
    private int english;
    private int clazz;
    public Account(int id,String name,int math,int english,int clazz){
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.clazz = clazz;
    }
    public int getId(){
        return id;
    }
    public int getMath(){
        return math;
    }
    public String getName(){
        return name;
    }
    public int getEnglish(){
        return english;
    }
    public int getClazz(){
        return clazz;
    }
}
