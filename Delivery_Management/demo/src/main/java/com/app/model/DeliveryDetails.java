package com.app.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import java.util.Date;
import lombok.Data;

@Data
@Embeddable
public class DeliveryDetails {

    @Column(name = "delivery_address")
    private String address;

    @Column(name = "delivery_city")
    private String city;

    @Column(name = "delivery_state")
    private String state;

    @Column(name = "delivery_zip_code")
    private String zipCode;

    @Column(name = "delivery_contact_name")
    private String contactName;

    @Column(name = "delivery_contact_phone")
    private String contactPhone;

    @Column(name = "delivery_preferred_date")
    private Date preferredDate;

    @Column(name = "delivery_preferred_time_slot")
    private String preferredTimeSlot;
}
