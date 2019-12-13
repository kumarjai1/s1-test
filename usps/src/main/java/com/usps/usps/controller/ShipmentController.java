package com.usps.usps.controller;

import com.usps.usps.model.Shipment;
import com.usps.usps.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    //TODO: Constructor injection for better code

    @Autowired
    ShipmentService shipmentService;

    @GetMapping("/{trackingnumber}")
    public String getShipmentDetails (@PathVariable Integer trackingnumber) {
        return shipmentService.findShipmentDetails(trackingnumber);
    }

    @PostMapping("/addshipment")
    public Shipment addShipment (@RequestBody Shipment shipment) {
        return shipmentService.addShipment(shipment);
    }


}
