package com.subset.subsetprojectrestapi.subset.entites;

import java.util.List;

public class SubsetRequest<T> {

    private List<T> inputSet;

    public SubsetRequest() {}

    public SubsetRequest(List<T> inputSet) {
        this.inputSet = inputSet;
    }

    public List<T> getInputSet() {
        return inputSet;
    }

    public void setInputSet(List<T> inputSet) {
        this.inputSet = inputSet;
    }
}
