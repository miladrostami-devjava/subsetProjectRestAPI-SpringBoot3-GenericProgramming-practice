package com.subset.subsetprojectrestapi.subset.entites;

import java.util.List;

public class SubsetRequest {
    private List<Integer> subSetInput;

    public SubsetRequest() {
    }

    public SubsetRequest(List<Integer> subSetInput) {
        this.subSetInput = subSetInput;
    }

    public List<Integer> getSubSetInput() {
        return subSetInput;
    }

    public void setSubSetInput(List<Integer> subSetInput) {
        this.subSetInput = subSetInput;
    }
}
