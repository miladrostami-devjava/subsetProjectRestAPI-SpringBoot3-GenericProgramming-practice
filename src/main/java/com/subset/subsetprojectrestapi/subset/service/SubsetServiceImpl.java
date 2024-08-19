package com.subset.subsetprojectrestapi.subset.service;

import com.subset.subsetprojectrestapi.subset.entites.SubsetRequest;
import com.subset.subsetprojectrestapi.subset.entites.SubsetResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SubsetServiceImpl<T> implements SubsetService<SubsetRequest<T>, SubsetResponse<T>> {

    private final Map<Integer, List<List<T>>> subsetsCache = new HashMap<>();

    @Override
    public SubsetResponse<T> calculateSubset(SubsetRequest<T> subsetRequest) {
        List<T> inputSet = subsetRequest.getInputSet();
        if (inputSet == null){
           throw new IllegalArgumentException("Input subset can not be null!");
        }
        int key = inputSet.hashCode();

        if (subsetsCache.containsKey(key)) {
            return new SubsetResponse<>(subsetsCache.get(key));
        }

        List<List<T>> result = generateSubsets(inputSet);

        subsetsCache.put(key, result);

        return new SubsetResponse<>(result);
    }

    private List<List<T>> generateSubsets(List<T> inputSet) {
        List<List<T>> subsets = new ArrayList<>();
        int n = inputSet.size();
        int numberOfSubsets = 1 << n;

        for (int i = 0; i < numberOfSubsets; i++) {
            List<T> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(inputSet.get(j));
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
