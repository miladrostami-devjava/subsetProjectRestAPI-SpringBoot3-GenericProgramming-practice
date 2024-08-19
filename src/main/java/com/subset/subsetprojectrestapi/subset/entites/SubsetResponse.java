package com.subset.subsetprojectrestapi.subset.entites;

import java.util.List;

public class SubsetResponse<T> {
    private List<List<T>> subsets;

    public SubsetResponse() {
    }

    public SubsetResponse(List<List<T>> subsets) {
        this.subsets = subsets;
    }

    public List<List<T>> getSubsets() {
        return subsets;
    }

    public void setSubsets(List<List<T>> subsets) {
        this.subsets = subsets;
    }
}
