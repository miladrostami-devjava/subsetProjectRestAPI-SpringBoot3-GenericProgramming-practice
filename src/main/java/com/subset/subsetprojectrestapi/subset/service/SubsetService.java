package com.subset.subsetprojectrestapi.subset.service;




public interface SubsetService<T, R> {
 R calculateSubset(T subsetRequest);
}