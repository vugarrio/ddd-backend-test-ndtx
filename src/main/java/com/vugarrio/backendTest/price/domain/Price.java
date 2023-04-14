package com.vugarrio.backendTest.price.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

    private Long id;

    private Long brandId;

    private String startDate;

    private String endDate;

    private Integer priceList;

    private Long productId;

     private Integer priority;

    private BigDecimal price;

    private String curr;

}
