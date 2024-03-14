package com.example.testback1.catalog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarageCatalogRepository extends CrudRepository<GarageCatalog,Long> {

    @Query("SELECT DISTINCT car.make FROM GarageCatalog c JOIN c.cars car WHERE c.id = ?1")
    List<String> findAllMakesByCatalog(long id);
}
