package com.quan.graphql.demo.graphql.repository;

import com.quan.graphql.demo.graphql.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository  extends JpaRepository<Owner,Long> {
}
