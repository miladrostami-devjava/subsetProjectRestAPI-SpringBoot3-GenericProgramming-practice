package com.subset.subsetprojectrestapi.subset.controller;

import com.subset.subsetprojectrestapi.subset.entites.SubsetRequest;
import com.subset.subsetprojectrestapi.subset.entites.SubsetResponse;
import com.subset.subsetprojectrestapi.subset.service.SubsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subsets")
public class SubsetController {

    private final SubsetService service;

    @Autowired
    public SubsetController(SubsetService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public ResponseEntity<SubsetResponse> calculateSubsets(@RequestBody SubsetRequest request){
     try {
         SubsetResponse response = service.calculateSubset(request);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }catch (Exception e){
         System.out.println(  "exception ---->>>" + e.getMessage());
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }



}
