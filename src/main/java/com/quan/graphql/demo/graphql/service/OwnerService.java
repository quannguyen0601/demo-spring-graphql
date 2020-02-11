package com.quan.graphql.demo.graphql.service;

import com.quan.graphql.demo.graphql.entity.Owner;
import com.quan.graphql.demo.graphql.entity.Vehicle;
import com.quan.graphql.demo.graphql.repository.OwnerRepository;
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

    @Transactional
    public Owner createOwner(String name, int age, String address) {
        final Owner owner = new Owner();

        owner.setName(name);
        owner.setAge(age);
        owner.setAddress(address);

        return this.repository.save(owner);
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
        Set<Vehicle> comments = repository.getOne(ownerId).getVehicles();
        log.info("Comment size {}",comments.size());
        return comments;
    }

}
