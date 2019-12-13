package com.usps.client.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
