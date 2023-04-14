package com.vugarrio.backendTest.price.infrastructure.repository.h2.repository;

import com.vugarrio.backendTest.price.domain.Price;
import com.vugarrio.backendTest.price.domain.repository.PriceRepository;
import com.vugarrio.backendTest.price.infrastructure.repository.mapper.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PriceDboRepository implements PriceRepository {

    private final SpringDataPriceRepository priceRepository;

    private final PriceEntityMapper priceMapper;

    @Override
    public Optional<Price> findPrice(Long brandId, Long productId, String startDate) {
        return priceRepository.findByBrandIdAndProductIdAndStartDate(brandId, productId, startDate).map(priceMapper::toDomain);
    }
}
