package model;

public class Customer {
    String name;
    String birth;
    String live;
    String images;

    public Customer(String name, String birth, String live, String images) {
        this.name = name;
        this.birth = birth;
        this.live = live;
        this.images = images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getLive() {
        return live;
    }

    public String getImages() {
        return images;
    }
}
