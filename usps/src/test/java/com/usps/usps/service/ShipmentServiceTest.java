package com.usps.usps.service;

import com.usps.usps.model.Shipment;
import com.usps.usps.repository.ShipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
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
        when(shipmentRepository.findByTrackingNumber(anyInt())).thenReturn(shipment);

        String foundShipmentDetails = shipmentService.findShipmentDetails(1234);
        System.out.println(foundShipmentDetails);
        assertNotNull(foundShipmentDetails);
        assertEquals(shipment.getDetails(), foundShipmentDetails);
    }

    @Test
    public void addShipment_ShipmentDataValid_Success() {
//        shipment.setDetails(null);
//        shipment.setTrackingNumber(0);
        when (shipmentRepository.save(any())).thenReturn(shipment);

        Shipment addedShipment = shipmentService.addShipment(shipment);

        assertNotNull(addedShipment);
        assertEquals(shipment.getDetails(), addedShipment.getDetails());
    }

}
