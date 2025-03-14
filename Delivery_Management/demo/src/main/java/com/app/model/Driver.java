

package com.app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Ensures proper inheritance behavior
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends User {

    private String licenseNumber;
    private String vehicleInfo;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Double latitude;
    private Double longitude;
    private Boolean isAvailable;
    private Double rating;
    private Integer completedDeliveries;
}
