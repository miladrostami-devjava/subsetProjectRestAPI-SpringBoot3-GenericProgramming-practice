package com.subset.subsetprojectrestapi.subset.service;

import com.subset.subsetprojectrestapi.subset.entites.SubsetRequest;
import com.subset.subsetprojectrestapi.subset.entites.SubsetResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetServiceImplTest {
    private final SubsetService subsetService = new SubsetServiceImpl();

    @Test
    public void testCalculateSubsets() {
        List<Integer> inputSet = Arrays.asList(1, 2, 3);
        SubsetRequest request = new SubsetRequest(inputSet);
        SubsetResponse response = (SubsetResponse) subsetService.calculateSubset(request);
        List<List<Integer>> expectedSubsets = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        );
        assertEquals(expectedSubsets.size(),response.getSubsets().size());
        assertEquals(expectedSubsets, response.getSubsets());


    }


}