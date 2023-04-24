package com.spring.bulk.service;

import com.spring.bulk.entity.PersonDetailsList;
import com.spring.bulk.repository.BulkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkService {
    @Autowired
    BulkRepository repo;
    public void bulkData(PersonDetailsList personDetailsList)
    {
        repo.saveAll(personDetailsList.getBulkList());
    }
}
