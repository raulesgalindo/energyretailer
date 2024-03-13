package com.vistra.energyretailer.model;

import lombok.Data;
import java.util.List;

@Data
public class MarketDesignationRequest {
    private MarketDesignationDate effectiveDate;
    private List<MarketDesignation> marketDesignations;
}