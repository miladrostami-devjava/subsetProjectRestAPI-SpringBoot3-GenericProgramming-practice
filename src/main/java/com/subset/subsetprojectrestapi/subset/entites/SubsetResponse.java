package com.subset.subsetprojectrestapi.subset.entites;

import java.util.List;

public class SubsetResponse {
    private List<List<Integer>> subsets;

    public SubsetResponse() {
    }

    public SubsetResponse(List<List<Integer>> subsets) {
        this.subsets = subsets;
    }

    public List<List<Integer>> getSubsets() {
        return subsets;
    }

    public void setSubsets(List<List<Integer>> subsets) {
        this.subsets = subsets;
    }
}
