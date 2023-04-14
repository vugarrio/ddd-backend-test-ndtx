package com.vugarrio.backendTest.price.infrastructure.rest.mapper;

import com.vugarrio.backendTest.price.domain.Price;
import com.vugarrio.backendTest.price.infrastructure.rest.dto.PriceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    PriceResponseDto toDto (Price entry);

    Price toDomain(PriceResponseDto entry);

}
