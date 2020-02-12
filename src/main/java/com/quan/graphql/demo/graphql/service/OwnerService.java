package com.quan.graphql.demo.graphql.service;

import com.quan.graphql.demo.graphql.entity.Owner;
import com.quan.graphql.demo.graphql.entity.Vehicle;
import com.quan.graphql.demo.graphql.repository.OwnerRepository;
import com.quan.graphql.demo.graphql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnerService {
    private final OwnerRepository repository;
    private final VehicleRepository vehicleRepository;

    @Transactional
    public Owner createOwner(String name, int age, String address) {
        final Owner owner = new Owner();

        owner.setName(name);
        owner.setAge(age);
        owner.setAddress(address);

        return this.repository.save(owner);
    }

    @Transactional
    public Owner assignVehicleToOwner(final long vehicleId, final long ownerId) {
        Vehicle vehicle = vehicleRepository.getOne(vehicleId);
        Owner owner = repository.getOne(ownerId);
        owner.setVehicle(vehicle);
        return repository.save(owner);
    }

    @Transactional(readOnly = true)
    public List<Owner> getAllOwner(final int count) {
        return this.repository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Owner> getOwner(final long id) {
        return this.repository.findById(id);
    }

    @Transactional(readOnly = true)
    public Set<Vehicle> getVehicles(long ownerId){
        Set<Vehicle> vehicles = repository.findById(ownerId).orElseThrow(()-> new NullPointerException("error can not find the ID")).getVehicles();
        log.info("vehicles size {}",vehicles.size());
        return vehicles;
    }

    @Transactional(readOnly = true)
    public Set<Vehicle> getVehicles(final Owner owner){
        Set<Vehicle> vehicles = owner.getVehicles();
        log.info("get in relation vehicles size {}",vehicles.size());
        return vehicles;
    }

}
