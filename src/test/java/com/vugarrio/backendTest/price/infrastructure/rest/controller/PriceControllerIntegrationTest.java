package com.vugarrio.backendTest.price.infrastructure.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String CONTENT_TYPE = "application/json";

    @BeforeEach
    public void setup() { }


    @Test
    public void getPrice_Cases() throws Exception {

        // ---- Test 1 ---
        String brandId = "1";
        String productId = "35455";
        String date = "2020-06-14-10.00.00";

        log.debug("------ Test 1 ------   [brandId={}, productId={}, date={}]", brandId, productId, date);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .queryParam("brandId", brandId)
                        .queryParam("productId", productId)
                        .queryParam("date", date))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31-23.59.59"));


        // ---- Test 2 ---
        brandId = "1";
        productId = "35455";
        date = "2020-06-14-16.00.00";

        log.debug("------ Test 2 ------   [brandId={}, productId={}, date={}]", brandId, productId, date);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .queryParam("brandId", brandId)
                        .queryParam("productId", productId)
                        .queryParam("date", date))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("25.45"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14-15.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14-18.30.00"));


        // ---- Test 3 ---
        brandId = "1";
        productId = "35455";
        date = "2020-06-14-21.00.00";

        log.debug("------ Test 3 ------   [brandId={}, productId={}, date={}]", brandId, productId, date);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .queryParam("brandId", brandId)
                        .queryParam("productId", productId)
                        .queryParam("date", date))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31-23.59.59"));


        // ---- Test 4 ---
        brandId = "1";
        productId = "35455";
        date = "2020-06-15-10.00.00";

        log.debug("------ Test 4 ------   [brandId={}, productId={}, date={}]", brandId, productId, date);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .queryParam("brandId", brandId)
                        .queryParam("productId", productId)
                        .queryParam("date", date))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("30.5"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15-11.00.00"));


        // ---- Test 5 ---
        brandId = "1";
        productId = "35455";
        date = "2020-06-16-21.00.00";

        log.debug("------ Test 5 ------   [brandId={}, productId={}, date={}]", brandId, productId, date);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .queryParam("brandId", brandId)
                        .queryParam("productId", productId)
                        .queryParam("date", date))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("38.95"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15-16.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31-23.59.59"));


    }

}