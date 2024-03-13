package com.vistra.energyretailer.controller;

import com.vistra.energyretailer.model.Unit;
import com.vistra.energyretailer.model.UnitResponse;
import com.vistra.energyretailer.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/units")
    public ResponseEntity<UnitResponse> getUnits(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String unitStartDate,
            @RequestParam(required = false) String unitEndDate,
            @RequestParam(required = false) String unitTypeCode,
            @RequestParam(required = false) Boolean draft,
            @RequestParam(required = false) String unitIdentifier,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "0") int pageNo) {

        Page<Unit> units = unitService.getUnits(name, unitStartDate, unitEndDate, unitTypeCode, draft, unitIdentifier, pageSize, pageNo);
        UnitResponse unitResponse = new UnitResponse(units.getContent(), units.getSize(), units.getTotalPages(), (int) units.getTotalElements());
        return ResponseEntity.ok().body(unitResponse);
    }
}