package com.vistra.energyretailer.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "unit_market_designation")
public class MarketDesignation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;


    @Column(name = "market_id")
    private Long marketId;

    @Column(name = "effective_date")
    private Timestamp effectiveDate;

    @Column(name = "market_share_percent")
    private Integer marketShare;

    @Column(name = "registration_code")
    private String registrationCode;

    // Constructors
    public MarketDesignation() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Long getMarketId() {
        return marketId;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(Integer marketShare) {
        this.marketShare = marketShare;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }
}