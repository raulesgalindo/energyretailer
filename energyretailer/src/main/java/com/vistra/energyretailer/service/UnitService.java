package com.vistra.energyretailer.service;

import com.vistra.energyretailer.model.Unit;
import com.vistra.energyretailer.model.MarketDesignation;
import com.vistra.energyretailer.repository.UnitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Page<Unit> getUnits(String name, String unitStartDate, String unitEndDate, String unitTypeCode, Boolean draft, String unitIdentifier, String marketCode, int pageSize, int pageNo) {
        Specification<Unit> specification = (root, query, criteriaBuilder) -> {
            // Initialize predicates list
            List<Predicate> predicates = new ArrayList<>();

            // Add filters based on query parameters
            if (!StringUtils.isEmpty(name)) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            if (!StringUtils.isEmpty(unitStartDate)) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("unitStartDate"), unitStartDate));
            }
            if (!StringUtils.isEmpty(unitEndDate)) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("unitEndDate"), unitEndDate));
            }
            if (!StringUtils.isEmpty(unitTypeCode)) {
                predicates.add(criteriaBuilder.equal(root.get("unitTypeCode"), unitTypeCode));
            }
            if (draft != null) {
                predicates.add(criteriaBuilder.equal(root.get("draft"), draft));
            }
            if (!StringUtils.isEmpty(unitIdentifier)) {
                predicates.add(criteriaBuilder.equal(root.get("unitIdentifier"), unitIdentifier));
            }
            // Add marketCode filter using join
            if (!StringUtils.isEmpty(marketCode)) {
                Join<Unit, MarketDesignation> marketJoin = root.join("marketDesignations");
                predicates.add(criteriaBuilder.equal(marketJoin.get("market").get("code"), marketCode));
                // Add filter for current date
                predicates.add(criteriaBuilder.lessThanOrEqualTo(marketJoin.get("effectiveDate"), LocalDate.now()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Create pageable object for pagination
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // Fetch units based on specifications and pagination
        return unitRepository.findAll(specification, pageable);
    }
}