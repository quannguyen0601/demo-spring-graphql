package com.quan.graphql.demo.graphql.service;

import com.quan.graphql.demo.graphql.entity.Vehicle;
import com.quan.graphql.demo.graphql.repository.OwnerRepository;
import com.quan.graphql.demo.graphql.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository ;
    private final OwnerRepository ownerRepository;

    public VehicleService(VehicleRepository vehicleRepository, OwnerRepository ownerRepository) {
        this.vehicleRepository = vehicleRepository ;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {

        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);

    }

    @Transactional
    public Vehicle createVehicleWithOwner(final String type, final String modelCode, final String brandName, final String launchDate, final long ownerId) {

        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        vehicle.setOwner(
                ownerRepository.getOne(ownerId)
        );

        return this.vehicleRepository.save(vehicle);

    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final long id) {
        return this.vehicleRepository.findById(id);
    }

}