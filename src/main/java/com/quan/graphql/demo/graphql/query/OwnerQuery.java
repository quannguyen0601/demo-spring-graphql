package com.quan.graphql.demo.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.quan.graphql.demo.graphql.entity.Owner;
import com.quan.graphql.demo.graphql.entity.Vehicle;
import com.quan.graphql.demo.graphql.service.OwnerService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class OwnerQuery implements GraphQLQueryResolver {
    private final OwnerService service;

    public OwnerQuery(OwnerService service) {
        this.service = service;
    }

    public Optional<Owner> owner(long id) {
        return service.getOwner(id);
    }

}
