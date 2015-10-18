package com.tcs.bfscoe.mobilebanking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.bfscoe.mobilebanking.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}

