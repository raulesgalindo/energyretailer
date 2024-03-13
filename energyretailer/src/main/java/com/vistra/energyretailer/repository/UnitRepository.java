package com.vistra.energyretailer.repository;


import com.vistra.energyretailer.model.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    Page<Unit> findAll(Specification<Unit> specification, Pageable pageable);
}