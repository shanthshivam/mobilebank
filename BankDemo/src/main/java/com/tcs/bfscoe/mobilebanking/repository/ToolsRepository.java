package com.tcs.bfscoe.mobilebanking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.bfscoe.mobilebanking.domain.AppRegistration;
import com.tcs.bfscoe.mobilebanking.domain.Tool;


public interface ToolsRepository extends MongoRepository<Tool, String>{

}

