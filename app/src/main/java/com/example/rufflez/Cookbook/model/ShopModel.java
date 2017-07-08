package com.example.rufflez.Cookbook.model;

/**
 * Created by rufflez on 10/4/15.
 */
public class ShopModel {
    private String itemNguyenLieu;

    public ShopModel(String itemNguyenLieu) {
        this.itemNguyenLieu = itemNguyenLieu;
    }

    public String getItemNguyenLieu() {        return itemNguyenLieu;
    }

    public void setItemNguyenLieu(String itemNguyenLieu) {
        this.itemNguyenLieu = itemNguyenLieu;
    }
}
