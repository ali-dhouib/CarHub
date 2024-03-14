package com.example.testback1.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageCatalogServices {

    @Autowired
    private GarageCatalogRepository garageCatalogRepository;

    public List<String> findAllMakesByCatalog(long id) {
        return garageCatalogRepository.findAllMakesByCatalog(id);
    }
}
