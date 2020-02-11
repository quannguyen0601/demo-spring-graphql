package com.quan.graphql.demo.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.quan.graphql.demo.graphql.entity.Vehicle;
import com.quan.graphql.demo.graphql.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private final VehicleService vehicleService;

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }

}