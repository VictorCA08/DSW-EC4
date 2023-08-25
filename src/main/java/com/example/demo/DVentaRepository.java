package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "dventas", path = "dventas")
public interface DVentaRepository extends CrudRepository<DetalleVenta, Long> {
    
}
