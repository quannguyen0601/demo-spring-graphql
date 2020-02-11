package com.quan.graphql.demo.graphql.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.quan.graphql.demo.graphql.entity.Owner;
import com.quan.graphql.demo.graphql.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerMutation implements GraphQLMutationResolver {
    @Autowired
    private final OwnerService  service;

    public OwnerMutation(OwnerService service) {
        this.service = service;
    }

    public Owner createOwner(String name,
                              int age,
                              String address) {
        return service.createOwner(name,age, address);
    }
}
