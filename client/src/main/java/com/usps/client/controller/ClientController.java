package com.usps.client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.usps.client.model.ShipmentBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/clientfe")
public class ClientController {



    @GetMapping("/shipment/{trackingnumber}")
    public String getShipmentDetailsFromUsps (@PathVariable Integer trackingnumber) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String res = restTemplate.exchange("http://localhost:9001/shipment/"+trackingnumber, HttpMethod.GET, entity, String.class).getBody();
        System.out.println(res);
        return res;
    }

    @PostMapping("shipment/addshipment")
    public ShipmentBean addShipment (@RequestBody ShipmentBean shipment) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ShipmentBean> entity = new HttpEntity<ShipmentBean>(shipment,headers);
        ShipmentBean createdShipment = restTemplate.exchange("http://localhost:9001/shipment/addshipment", HttpMethod.POST, entity, ShipmentBean.class).getBody();
        return createdShipment;
    }

//    private static String createShipmentInJson(Integer trackingNumber, String details) {
//        return "{ \"trackingNumber\": \"" + trackingNumber + "\", " +
//                "\"details\":\"" + details + "\"}";
//    }

}
