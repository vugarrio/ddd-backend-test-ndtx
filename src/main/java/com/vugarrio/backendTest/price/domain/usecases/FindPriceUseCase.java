package com.vugarrio.backendTest.price.domain.usecases;

import com.vugarrio.backendTest.price.domain.Price;

import java.util.Optional;

public interface FindPriceUseCase {

    Optional<Price> findPrice(Long brandId, Long productId, String startDate);

}
