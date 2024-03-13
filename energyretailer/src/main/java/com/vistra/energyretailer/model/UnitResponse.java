package com.vistra.energyretailer.model;

import java.util.List;
public class UnitResponse<T> {
    private List<T> records;
    private int pageSize;
    private int totalPages;
    private int totalRecords;

    public UnitResponse(List<T> records, int pageSize, int totalPages, int totalRecords) {
        this.records = records;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalRecords = totalRecords;
    }

    // Getters and setters
    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
