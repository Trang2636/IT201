package org.example.seasion7_bai5.model;
import java.util.List;

public class Combo {
    private List<String> itemList;
    private String bannerPath;

    public Combo() {
    }

    public Combo(List<String> itemList, String bannerPath) {
        this.itemList = itemList;
        this.bannerPath = bannerPath;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }
}
