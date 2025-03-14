
package com.app.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long driverId;

    @Enumerated(EnumType.STRING)
    private IncidentType type;

    private String description;

    @Enumerated(EnumType.STRING)
    private IncidentStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date resolvedAt;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedAt;

    private String priority;
}
