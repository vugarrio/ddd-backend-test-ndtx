package com.vugarrio.backendTest.price.infrastructure.rest.controller;

import com.vugarrio.backendTest.price.domain.Price;
import com.vugarrio.backendTest.price.domain.common.LocalDateUtility;
import com.vugarrio.backendTest.price.domain.usecases.FindPriceUseCase;
import com.vugarrio.backendTest.price.infrastructure.rest.dto.PriceResponseDto;
import com.vugarrio.backendTest.price.infrastructure.rest.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PriceController  implements PricesApi {

    private final FindPriceUseCase findPriceUseCase;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<PriceResponseDto> getPrice(Long brandId, Long productId, String date) {
        log.debug(":: getPrice :: Begin - [brandId={}, productId={}, date={}]", brandId, productId, date);
        LocalDateUtility.validateDateString(date);
        final Optional<Price> price = findPriceUseCase.findPrice(brandId, productId, date);
        log.debug(":: getPrice :: Result: {}", price.isPresent() ? price.get() : "empty");
        if (price.isPresent()) {
            return new ResponseEntity<>(userMapper.toDto(price.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
