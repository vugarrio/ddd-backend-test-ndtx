package com.vugarrio.backendTest.price.infrastructure.repository.h2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "prices")
public class PriceEntity {

    public static final String ID_COLUMN_NAME = "id";
    public static final String BRAND_ID_COLUMN_NAME = "brand_id";
    public static final String START_DATE_COLUMN_NAME = "start_date";
    public static final String END_DATE_COLUMN_NAME = "end_date";
    public static final String PRICE_LIST_COLUMN_NAME = "price_list";
    public static final String PRODUCT_ID_COLUMN_NAME = "product_id";
    public static final String PRIORITY_COLUMN_NAME = "priority";
    public static final String PRICE_COLUMN_NAME = "price";
    public static final String CURR_COLUMN_NAME = "curr";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID_COLUMN_NAME)
    private Long id;

    @Column(name = BRAND_ID_COLUMN_NAME)
    private Long brandId;

    @Column(name = START_DATE_COLUMN_NAME)
    private String startDate;

    @Column(name = END_DATE_COLUMN_NAME)
    private String endDate;

    @Column(name = PRICE_LIST_COLUMN_NAME)
    private Integer priceList;

    @Column(name = PRODUCT_ID_COLUMN_NAME)
    private Long productId;

    @Column(name = PRIORITY_COLUMN_NAME)
    private Integer priority;

    @Column(name = PRICE_COLUMN_NAME)
    private BigDecimal price;

    @Column(name = CURR_COLUMN_NAME)
    private String curr;

}
