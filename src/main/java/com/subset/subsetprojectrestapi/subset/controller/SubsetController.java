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

    private final SubsetService<SubsetRequest<?>, SubsetResponse<?>> subsetService;

    @Autowired
    public SubsetController(SubsetService<SubsetRequest<?>, SubsetResponse<?>> subsetService) {
        this.subsetService = subsetService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<SubsetResponse<?>> calculateSubsets(@RequestBody SubsetRequest<?> request) {
        if (request.getInputSet() == null){
            throw new IllegalArgumentException("input can not empty!");
        }
        SubsetResponse<?> response = subsetService.calculateSubset(request);
        return ResponseEntity.ok(response);
    }



}

//region SubsetController generic method
/*@RestController
@RequestMapping("/api/subsets")
public class SubsetController<T, R> {

    private final SubsetService<T, R> subsetService;

    @Autowired
    public SubsetController(SubsetService<T, R> subsetService) {
        this.subsetService = subsetService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<R> calculateSubsets(@RequestBody T request) {
        if (request == null){
            throw new IllegalArgumentException("Input cannot be empty!");
        }
        R response = subsetService.calculateSubset(request);
        return ResponseEntity.ok(response);
    }
}*/
//endregion
