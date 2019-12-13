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
    public String addShipment (@RequestBody Integer trackingNumber, String details) throws JsonProcessingException {

        final String uri = "http://localhost:9001/shipment/addshipment";
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = createShipmentInJson(trackingNumber, details);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json, httpHeaders);
        String result = restTemplate.postForObject(uri, entity, String.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(shipment.toString(), httpHeaders);
//        ShipmentBean res = restTemplate.postForObject("http://localhost:9001/shipment/addshipment", entity, ShipmentBean.class);
//        JsonNode json = objectMapper.readTree(String.valueOf(res));
//        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = objectWriter.writeValueAsString(res);
//        String json = objectMapper.writeValueAsString(res);

//        System.out.println(json);
//        System.out.println(res);
        return result;
    }

    private static String createShipmentInJson(Integer trackingNumber, String details) {
        return "{ \"trackingNumber\": \"" + trackingNumber + "\", " +
                "\"details\":\"" + details + "\"}";
    }

}
