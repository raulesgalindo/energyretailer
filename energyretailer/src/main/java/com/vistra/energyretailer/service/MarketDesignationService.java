package com.vistra.energyretailer.service;

import com.vistra.energyretailer.model.*;
import com.vistra.energyretailer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MarketDesignationService {

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private MarketDesignationRepository marketDesignationRepository;

    public void setMarketDesignations(Long unitId, MarketDesignationRequest request) {
        // Validate unit existence
        Unit unit = unitRepository.findById(unitId).orElseThrow(() -> new RuntimeException("Unit not found"));

        // Validate market designations
        List<MarketDesignation> marketDesignations = request.getMarketDesignations();
        if (marketDesignations.isEmpty()) {
            throw new RuntimeException("At least 1 market designation must be passed");
        }

        // Validate total market share
        int totalMarketShare = marketDesignations.stream().mapToInt(MarketDesignation::getMarketShare).sum();
        if (totalMarketShare != 100) {
            throw new RuntimeException("Total market share must be exactly 100");
        }

        // Validate uniqueness of marketIds
        long distinctMarketIds = marketDesignations.stream().map(MarketDesignation::getMarketId).distinct().count();
        if (distinctMarketIds != marketDesignations.size()) {
            throw new RuntimeException("All marketIds in the list must be different");
        }

        // Validate uniqueness of registration code per unit and market
        marketDesignations.forEach(md -> {
            if (marketDesignationRepository.existsByUnitIdAndMarketIdAndRegistrationCode(unitId, md.getMarketId(), md.getRegistrationCode())) {
                throw new RuntimeException("Registration code is not unique per unit and market");
            }
        });

        // Clear existing market designations for the unit
        marketDesignationRepository.deleteByUnitId(unitId);

        LocalDate date = LocalDate.parse(request.getEffectiveDate().getDate());
        LocalTime time = LocalTime.parse(request.getEffectiveDate().getTime());
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        // Save new market designations
        marketDesignations.forEach(md -> {
            md.setUnit(unit);
            md.setEffectiveDate(timestamp);
            marketDesignationRepository.save(md);
        });
    }
}