package com.geeks.homeapp6;

public class Car {

    private String name;

    private String avatar;

    public Car(String name, String avatar){
        this.name = name;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
