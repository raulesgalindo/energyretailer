package com.vistra.energyretailer.model;
import lombok.Data;

@Data
public class ErrorResponse {
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}