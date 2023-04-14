package com.vugarrio.backendTest.price.application.usecases;

import com.vugarrio.backendTest.price.domain.usecases.FindPriceUseCase;
import com.vugarrio.backendTest.price.domain.Price;
import com.vugarrio.backendTest.price.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindPriceUseCaseImpl implements FindPriceUseCase {

    private final PriceRepository priceRepository;

    @Override
    public Optional<Price> findPrice(Long brandId, Long productId, String startDate) {
        return priceRepository.findPrice(brandId, productId, startDate);
    }
}
