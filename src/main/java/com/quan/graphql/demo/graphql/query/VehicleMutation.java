package com.quan.graphql.demo.graphql.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.quan.graphql.demo.graphql.entity.Vehicle;
import com.quan.graphql.demo.graphql.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleMutation implements GraphQLMutationResolver {
    @Autowired
    private final VehicleService vehicleService;

    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }

    public Vehicle createVehicleWithOwner(final String type, final String modelCode, final String brandName, final String launchDate,final long ownerId ) {
        return this.vehicleService.createVehicleWithOwner(type, modelCode, brandName, launchDate, ownerId);
    }

}