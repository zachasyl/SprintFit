package com.cs5500.group9.myFitnessApp;

import org.springframework.data.repository.CrudRepository;

import com.cs5500.group9.myFitnessApp.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
