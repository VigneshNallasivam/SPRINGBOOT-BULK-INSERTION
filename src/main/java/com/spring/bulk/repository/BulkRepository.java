package com.spring.bulk.repository;

import com.spring.bulk.entity.Bulk;
import com.spring.bulk.entity.PersonDetailsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BulkRepository extends JpaRepository<Bulk,Integer>{
}
