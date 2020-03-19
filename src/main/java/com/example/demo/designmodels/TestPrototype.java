package com.example.demo.designmodels;

class Car implements Cloneable{
    private int id;
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Car clone(){
        try {
            return (Car)super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
class CarPrototype implements Cloneable{
    private int id;
    private Car car;
    public Car getCar() {return car;}
    public void setCar(Car car) {this.car = car;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Object clone(){
        try {
            boolean deep = true;
            if (deep){
                /**
                 * 深复制，复制出了两辆车
                 * */
                CarPrototype prototype = (CarPrototype)super.clone();
                prototype.setCar((Car)this.car.clone());
                // 继续复制其他引用对象
                return prototype;

            }else{
                /**
                 * 浅复制 ，是同一辆车
                 * */
                return super.clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
public class TestPrototype {

    public void test(){
        CarPrototype p1 = new CarPrototype();
        p1.setCar(new Car());
        p1.setId(1);
        // 复制
        CarPrototype p2 = (CarPrototype)p1.clone();
        p2.setId(2);

    }
} 