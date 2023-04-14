package com.vugarrio.backendTest.price.infrastructure.repository.mapper;

import com.vugarrio.backendTest.price.domain.Price;
import com.vugarrio.backendTest.price.infrastructure.repository.h2.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Price toDomain(PriceEntity entry);

    PriceEntity toDbo(Price entry);
}
