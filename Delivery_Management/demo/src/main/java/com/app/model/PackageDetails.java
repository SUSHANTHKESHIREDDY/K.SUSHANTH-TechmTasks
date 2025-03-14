package com.app.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Embeddable
public class PackageDetails {


    private String description;

    private Double weight;

    private String dimensions;

   
    private String specialInstructions;
}
