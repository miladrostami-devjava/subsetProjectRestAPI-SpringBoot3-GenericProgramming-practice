package com.subset.subsetprojectrestapi.subset.service;

import com.subset.subsetprojectrestapi.subset.entites.SubsetRequest;
import com.subset.subsetprojectrestapi.subset.entites.SubsetResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubsetServiceImpl implements SubsetService {
    private final Map<Integer, List<List<Integer>>> subSetsCache = new HashMap<>();


    @Override
    public SubsetResponse calculateSubset(SubsetRequest subsetRequest) {
        List<Integer> inputSubset = subsetRequest.getSubSetInput();
        int key = inputSubset.hashCode();

        if (subSetsCache.containsKey(key)) {
            return new SubsetResponse(subSetsCache.get(key));
        }

        List<List<Integer>> result = generateSubsets(inputSubset);
        subSetsCache.put(key, result);
        return new SubsetResponse(result);
    }

    private List<List<Integer>> generateSubsets(List<Integer> inputSubset) {
        List<List<Integer>> subsets = new ArrayList<>();
        int inputSize = inputSubset.size();
        int numberOfSubsets = 1 << inputSize;

        for (int i = 0; i < numberOfSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < inputSize; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(inputSubset.get(j));
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }

}
