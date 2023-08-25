package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "infoventa", path = "infoventa")
public interface InfoVentaRepository extends CrudRepository<InfoVenta, Long> {
    
}
