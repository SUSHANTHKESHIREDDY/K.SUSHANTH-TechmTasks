package com.app.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "orderss")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String driverName;

    @Embedded
    private PackageDetails packageDetails;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "address", column = @Column(name = "pickup_address")),
        @AttributeOverride(name = "city", column = @Column(name = "pickup_city")),
        @AttributeOverride(name = "state", column = @Column(name = "pickup_state")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "pickup_zip_code")),
        @AttributeOverride(name = "contactName", column = @Column(name = "pickup_contact_name")),
        @AttributeOverride(name = "contactPhone", column = @Column(name = "pickup_contact_phone"))
    })
    private PickupDetails pickupDetails;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "address", column = @Column(name = "delivery_address")),
        @AttributeOverride(name = "city", column = @Column(name = "delivery_city")),
        @AttributeOverride(name = "state", column = @Column(name = "delivery_state")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "delivery_zip_code")),
        @AttributeOverride(name = "contactName", column = @Column(name = "delivery_contact_name")),
        @AttributeOverride(name = "contactPhone", column = @Column(name = "delivery_contact_phone")),
        @AttributeOverride(name = "preferredDate", column =  @Column(name="delivery_preferred_date")),
        @AttributeOverride(name = "preferredTimeSlot", column = @Column(name="delivery_preferred_time_slot"))
    })
    private DeliveryDetails deliveryDetails;

    private boolean termsAccepted;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Double amount;
    private String paymentMethod;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StatusHistory> statusHistory;
}

