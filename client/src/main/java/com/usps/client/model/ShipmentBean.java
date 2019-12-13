package com.usps.client.model;

public class ShipmentBean {

    public Integer trackingNumber;
    public String details;

    public ShipmentBean(Integer trackingNumber, String details) {

        this.trackingNumber = trackingNumber;
        this.details = details;
    }

    public Integer getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Integer trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
