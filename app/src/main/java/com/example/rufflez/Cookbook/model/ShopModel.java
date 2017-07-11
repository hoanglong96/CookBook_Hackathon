package com.example.rufflez.Cookbook.model;

import java.util.ArrayList;

/**
 * Created by rufflez on 10/4/15.
 */
public class ShopModel {
    private String headerTitle;
    private ArrayList<String> allItemNguyenLieu;

    public ShopModel(String headerTitle, ArrayList<String> allItemNguyenLieu) {
        this.headerTitle = headerTitle;
        this.allItemNguyenLieu = allItemNguyenLieu;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<String> getAllItemNguyenLieu() {
        return allItemNguyenLieu;
    }

    public void setAllItemNguyenLieu(ArrayList<String> allItemNguyenLieu) {
        this.allItemNguyenLieu = allItemNguyenLieu;
    }
}
