package com.geeks.homeapp6;

public class Car {

    private String name;

    private String avatar;

    private boolean isSelected;

    public Car(String name, String avatar){
        this.name = name;
        this.avatar = avatar;
        this.isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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
