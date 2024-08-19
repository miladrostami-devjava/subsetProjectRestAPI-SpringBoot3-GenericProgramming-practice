package com.subset.subsetprojectrestapi.subset.service;

import com.subset.subsetprojectrestapi.subset.entites.SubsetRequest;
import com.subset.subsetprojectrestapi.subset.entites.SubsetResponse;
import org.springframework.stereotype.Service;


public interface SubsetService {
 SubsetResponse calculateSubset(SubsetRequest subsetRequest);
}
