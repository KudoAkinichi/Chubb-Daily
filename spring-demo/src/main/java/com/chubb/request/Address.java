package com.chubb.request;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Address {

    @Min(value = 1, message = "House number must be positive")
    private Integer house;

    @NotNull(message = "Pin code is required")
    @Min(value = 100000, message = "Pin must be a 6-digit number")
    @Max(value = 999999, message = "Pin must be a 6-digit number")
    private Integer pin;

    public Address() {}

    public Integer getHouse() { return house; }
    public void setHouse(Integer house) { this.house = house; }

    public Integer getPin() { return pin; }
    public void setPin(Integer pin) { this.pin = pin; }
}
