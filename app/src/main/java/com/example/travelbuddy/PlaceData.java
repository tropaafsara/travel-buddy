package com.example.travelbuddy;

public class PlaceData {
    private String itemName;
    private String itemDescription;
    private String itemPrice;
    private String itemImage;

    public PlaceData(){

    }
    public PlaceData(String itemName, String itemDescription, String itemPrice, String itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemImage() {
        return itemImage;
    }
}
