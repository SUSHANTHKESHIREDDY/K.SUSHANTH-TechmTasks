package com.app.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long customerId;
    private Long driverId;
    private int rating;
    private String comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
