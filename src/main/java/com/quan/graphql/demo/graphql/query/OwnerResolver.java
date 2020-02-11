package com.quan.graphql.demo.graphql.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.quan.graphql.demo.graphql.entity.Owner;
import com.quan.graphql.demo.graphql.entity.Vehicle;
import com.quan.graphql.demo.graphql.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class OwnerResolver implements GraphQLResolver<Owner> {

    private final OwnerService service;

    Set<Vehicle> vehicles(Owner owner){
        return service.getVehicles(owner.getId());
    }

    Set<Vehicle> getVehicles(Owner owner){
        return service.getVehicles(owner.getId());
    }
}
