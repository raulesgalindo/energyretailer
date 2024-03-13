package com.vistra.energyretailer.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "internal_short_name")
    private String internalShortName;

    @Column(name = "internal_long_name")
    private String internalLongName;

    @Column(name = "unit_start_date")
    private LocalDateTime unitStartDate;

    @Column(name = "unit_end_date")
    private LocalDateTime unitEndDate;

    @Column(name = "unit_type_id")
    private Long unitTypeCode;

    @Column(name = "draft")
    private Boolean draft;

    @Column(name = "unit_identifier")
    private String unitIdentifier;

    // Constructors
    public Unit() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalShortName() {
        return internalShortName;
    }

    public void setInternalShortName(String internalShortName) {
        this.internalShortName = internalShortName;
    }

    public String getInternalLongName() {
        return internalLongName;
    }

    public void setInternalLongName(String internalLongName) {
        this.internalLongName = internalLongName;
    }

    public LocalDateTime getUnitStartDate() {
        return unitStartDate;
    }

    public void setUnitStartDate(LocalDateTime unitStartDate) {
        this.unitStartDate = unitStartDate;
    }

    public LocalDateTime getUnitEndDate() {
        return unitEndDate;
    }

    public void setUnitEndDate(LocalDateTime unitEndDate) {
        this.unitEndDate = unitEndDate;
    }

    public Long getUnitTypeCode() {
        return unitTypeCode;
    }

    public void setUnitTypeCode(Long unitTypeCode) {
        this.unitTypeCode = unitTypeCode;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public String getUnitIdentifier() {
        return unitIdentifier;
    }

    public void setUnitIdentifier(String unitIdentifier) {
        this.unitIdentifier = unitIdentifier;
    }
}