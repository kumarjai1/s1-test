package com.usps.usps.service;

import com.usps.usps.model.Shipment;

public interface ShipmentService {

    String findShipmentDetails(Integer trackingnumber);
    Shipment addShipment(Shipment shipment);
}
