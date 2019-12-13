package com.usps.usps.service;

import com.usps.usps.model.Shipment;
import com.usps.usps.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Override
    public String findShipmentDetails(Integer trackingnumber) {
        //TODO: add exception handling
        Shipment foundShipment = shipmentRepository.findByTrackingNumber(trackingnumber);
        return foundShipment.getDetails();
    }

    @Override
    public Shipment addShipment(Shipment shipment) {
        //TODO: check if given values are valid
        return shipmentRepository.save(shipment);
    }
}
