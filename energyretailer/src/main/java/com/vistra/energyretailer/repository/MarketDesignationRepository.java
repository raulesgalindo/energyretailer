package com.vistra.energyretailer.repository;

import com.vistra.energyretailer.model.MarketDesignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDesignationRepository extends JpaRepository<MarketDesignation, Long> {
    void deleteByUnitId(Long unitId);
    boolean existsByUnitIdAndMarketIdAndRegistrationCode(Long unitId, Long marketId, String registrationCode);
}