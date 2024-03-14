package com.example.testback1.controllers;

import com.example.testback1.catalog.GarageCatalogServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalogs")
//@Api(tags = "Catalog Management")
public class GarageCatalogController {

    @Autowired
    private GarageCatalogServices catalogService;

    @GetMapping("/{id}/makes")
    //@ApiOperation(value = "Get all makes for a catalog", notes = "Retrieves all makes for a catalog.")
    public ResponseEntity<List<String>> findAllMakesByCatalog(@PathVariable Long id) {
        List<String> makes = catalogService.findAllMakesByCatalog(id);
        if (makes != null) {
            return new ResponseEntity<>(makes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
