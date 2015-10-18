package com.tcs.bfscoe.mobilebanking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.bfscoe.mobilebanking.domain.AppRegistration;

public interface AppRegistrationRepository extends MongoRepository<AppRegistration, String>{

}

