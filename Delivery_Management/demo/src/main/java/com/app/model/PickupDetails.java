package com.app.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Embeddable
public class PickupDetails {
    
    @Column(name = "pickup_address")
    private String address;

    @Column(name = "pickup_city")
    private String city;

    @Column(name = "pickup_state")
    private String state;

    @Column(name = "pickup_zip_code")
    private String zipCode;

    @Column(name = "pickup_contact_name")
    private String contactName;

    @Column(name = "pickup_contact_phone")
    private String contactPhone;
}

