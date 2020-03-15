package com.example.demo.designmodels;

public class SingletonDesign {

    private SingletonDesign(){};


    private enum Singleton  {
        INSTANCE;

        private final SingletonDesign instance;

        Singleton(){
            instance=new SingletonDesign();
        }

        private SingletonDesign getInstance(){
            return  instance;
        }
    }

    public static SingletonDesign getInstance(){
       return Singleton.INSTANCE.getInstance();
    }


    public static void main(String[] args){
        SingletonDesign instance1= SingletonDesign.getInstance();
        SingletonDesign instance2= SingletonDesign.getInstance();

        System.out.println(instance1==instance2);
    }
}
