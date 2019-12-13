package com.usps.usps.repository;

import com.usps.usps.model.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Integer> {

    Shipment findByTrackingNumber(Integer trackingNumber);
}
