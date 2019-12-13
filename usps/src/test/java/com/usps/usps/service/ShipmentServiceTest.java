package com.usps.usps.service;

import com.usps.usps.model.Shipment;
import com.usps.usps.repository.ShipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class ShipmentServiceTest {

    private Shipment shipment;
    private Integer trackingnumber;
    private String details;


    public ShipmentServiceTest() {
        shipment = new Shipment();
        shipment.setId(1L);
        shipment.setTrackingNumber(1234);
        shipment.setDetails("Cog world");
    }

    @BeforeEach
    public void init () {
        shipment.setId(1L);
        shipment.setTrackingNumber(1234);
        shipment.setDetails("Cog world");
    }

    @InjectMocks
    ShipmentServiceImpl shipmentService;

    @Mock
    ShipmentRepository shipmentRepository;

    @Test
    public void getShipment_ShipmentExists_Success() {
        System.out.println(shipment.getDetails());
        when(shipmentRepository.findByTrackingNumber(anyInt())).thenReturn(shipment);

        String foundShipmentDetails = shipmentService.findShipmentDetails(1234);
        assertEquals(shipment.getDetails(), foundShipmentDetails);
    }

}
