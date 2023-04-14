package com.vugarrio.backendTest.price.domain.repository;


import com.vugarrio.backendTest.price.domain.Price;

import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findPrice(Long brandId, Long productId, String startDate);

}
