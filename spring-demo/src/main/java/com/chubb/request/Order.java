package com.chubb.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {

    @NotBlank(message = "Item name cannot be empty")
    private String item;

    @Min(value = 1, message = "Price must be at least 1")
    private float price;

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
}
