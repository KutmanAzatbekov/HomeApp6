package com.geeks.homeapp6;

public class User {
    private String model;
    private Integer price;
    private String avatarUrl;

    private boolean isSelected2;

    public User(String model, Integer price, String avatarUrl){
        this.model = model;
        this.price = price;
        this.avatarUrl = avatarUrl;
        this.isSelected2 = false;
    }

    public boolean isSelected2(){
        return isSelected2;
    }

    public void setSelected2(boolean selected2) {
        isSelected2 = selected2;
    }

    public Integer getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
