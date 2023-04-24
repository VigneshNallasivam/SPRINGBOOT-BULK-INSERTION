package com.spring.bulk.controller;

import com.spring.bulk.entity.Bulk;
import com.spring.bulk.entity.PersonDetailsList;
import com.spring.bulk.service.BulkService;
import com.spring.bulk.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BulkController
{
    @Autowired
    BulkService service;
    @PostMapping("/allDetails")
    public ResponseEntity<Response> overall(@RequestBody PersonDetailsList personDetailsList)
    {
        service.bulkData(personDetailsList);
        Response response = new Response("All the data were fetched",personDetailsList);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
