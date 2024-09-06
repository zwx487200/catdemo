package com.example.catdemo;

//动物接口
interface Animal{
    public void speak();
}
//人实现类
class Man implements Animal{
    @Override
    public void speak() {
        System.out.println("我是人我会说话：哈哈哈！！！");
    }
}
//狗实现类
class Dog implements Animal{
    @Override
    public void speak() {
        System.out.println("我是小狗不会说话：汪汪汪！！！");
    }
}
//工厂类
class Factory{
    public Animal getAnimal(String name){
        if("man".equals(name)){
            return new Man();
        }else{
            return new Dog();
        }
    }
}


class Factory1{
    public Object getAnimal(String className) throws Exception{
        Class<?> cls = Class.forName(className);
        Object obj = cls.newInstance();
        return obj;
    }
}

//测试类
public class GeneralFactory {
    public static void main(String[] args) throws Exception{
        Factory factory = new Factory();
        Animal an = factory.getAnimal("dog");
        an.speak();
        Factory1 factory1 = new Factory1();
        Animal an1 = (Animal)factory1.getAnimal("com.example.catdemo.Man");
        an1.speak();
    }
}