package com.subset.subsetprojectrestapi.subset.controller;

import com.subset.subsetprojectrestapi.subset.entites.SubsetRequest;
import com.subset.subsetprojectrestapi.subset.entites.SubsetResponse;
import com.subset.subsetprojectrestapi.subset.service.SubsetService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SubsetControllerTest {

    @Mock
    private SubsetService subsetService;

    @InjectMocks
    private SubsetController subsetController;

    private MockMvc mockMvc;

    public SubsetControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(subsetController).build();
    }

    @Test
    public void testCalculateSubsets() throws Exception {
        List<Integer> inputSet = Arrays.asList(1, 2, 3);
        SubsetRequest request = new SubsetRequest(inputSet);

        List<List<Integer>> subsets = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        );
        SubsetResponse response = new SubsetResponse(subsets);

        when(subsetService.calculateSubset(request)).thenReturn(response);

        String inputJson = "[1, 2, 3]";
        String expectedJson = "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]";

        mockMvc.perform((RequestBuilder) post("/api/subsets/calculate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(expectedJson));





    }
}