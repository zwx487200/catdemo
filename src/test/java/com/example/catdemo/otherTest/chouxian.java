package com.example.catdemo.otherTest;


public class chouxian {
    public static void main(String[] args) {
        tongshijicheng tongshijicheng= new tongshijicheng();
        shixianjiekou shixianjiekou= new shixianjiekou();
        shixianchouxian shixianchouxian = new shixianchouxian();
        System.out.println(tongshijicheng.getage());
        System.out.println(tongshijicheng.getname());
        System.out.println(tongshijicheng.getname2());
        System.out.println(shixianjiekou.getname());
        System.out.println(shixianchouxian.getage());
    }
}
class tongshijicheng extends A implements jiekouA {

    @Override
    String getage() {
        return "tongshijicheng";
    }

    @Override
    public String getname2() {
        return "";
    }
}

class shixianjiekou implements jiekouA{
    @Override
    public String getname2() {
        return "";
    }

    @Override
    public String getname() {
        return "shixianjiekou";
    }

    @Override
    public boolean duiduidui() {
        return false;
    }
}

class shixianchouxian extends A{

    @Override
    String getage() {
        return "shixianchouxian";
    }
}
