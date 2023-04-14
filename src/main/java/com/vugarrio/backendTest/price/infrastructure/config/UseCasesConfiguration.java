package com.vugarrio.backendTest.price.infrastructure.config;

import com.vugarrio.backendTest.price.domain.usecases.FindPriceUseCase;
import com.vugarrio.backendTest.price.application.usecases.FindPriceUseCaseImpl;
import com.vugarrio.backendTest.price.domain.repository.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public FindPriceUseCase findPriceUseCase(PriceRepository priceRepository) {
        return new FindPriceUseCaseImpl(priceRepository);
    }
}
