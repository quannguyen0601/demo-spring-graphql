package com.quan.graphql.demo.graphql.repository;


import com.quan.graphql.demo.graphql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}