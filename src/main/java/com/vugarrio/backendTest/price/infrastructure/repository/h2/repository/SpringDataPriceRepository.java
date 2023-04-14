package com.vugarrio.backendTest.price.infrastructure.repository.h2.repository;


import com.vugarrio.backendTest.price.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataPriceRepository  extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT * FROM Prices WHERE brand_id = :brandId AND product_id = :productId AND PARSEDATETIME(start_date, 'yyyy-MM-dd-HH.mm.ss') < PARSEDATETIME(:date, 'yyyy-MM-dd-HH.mm.ss') AND PARSEDATETIME(end_date, 'yyyy-MM-dd-HH.mm.ss')  > PARSEDATETIME(:date, 'yyyy-MM-dd-HH.mm.ss') order by priority DESC limit 1", nativeQuery = true)
    Optional<PriceEntity> findByBrandIdAndProductIdAndStartDate( Long brandId, Long productId, String date);


}
