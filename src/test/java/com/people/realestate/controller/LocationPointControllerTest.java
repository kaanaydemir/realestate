package com.people.realestate.controller;

import com.google.gson.Gson;
import com.people.realestate.dtos.restdtos.createlocationpoint.CreateLocationPointRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(LocationPointController.class)
public class LocationPointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenLocationPointCreateRequest_whenCreateLocationPoint_thenReturnLocationPoint() throws Exception {
        CreateLocationPointRequest request = new CreateLocationPointRequest("Adana", 1L, 0);


        ResultActions response = mockMvc.perform(post("/api/product/").contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(request)))
                .andExpect(status().isCreated());

        response.andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.name", is("Adana")))
                .andExpect(jsonPath("$.parentLocationPointId", is(1)))
                .andExpect(jsonPath("$.locationPointType", is(0)));

    }
}