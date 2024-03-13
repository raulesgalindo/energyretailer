package com.vistra.energyretailer.controller;

import com.vistra.energyretailer.model.*;
import com.vistra.energyretailer.service.MarketDesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarketDesignationController {

	@Autowired
    private MarketDesignationService marketDesignationService;

    @PostMapping("/marketdesignations/{unitId}")
    public ResponseEntity<?> setMarketDesignations(@PathVariable Long unitId, @RequestBody MarketDesignationRequest request) {
        try {
            marketDesignationService.setMarketDesignations(unitId, request);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }
}
