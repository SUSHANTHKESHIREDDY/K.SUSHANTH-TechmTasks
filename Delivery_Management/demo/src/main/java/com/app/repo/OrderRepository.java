package com.app.repo;

import com.app.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

    List<Order> findByDriverId(Long driverId);

    List<Order> findByStatus(String status);
    
    @Query("SELECT o FROM Order o WHERE o.status = 'ACTIVE' AND o.driver.id = :driverId")
    Order findActiveDeliveryForDriver(Long driverId);

    @Query("SELECT o FROM Order o ORDER BY o.createdAt DESC LIMIT :limit")
    List<Order> findTopRecentOrders(int limit);

    @Query("SELECT o FROM Order o WHERE o.createdAt >= " +
            "CASE :unit " +
            "WHEN 'DAY' THEN CAST(DATE_SUB(CURRENT_DATE, :period, 'DAY') AS timestamp) " +
            "WHEN 'MONTH' THEN CAST(DATE_SUB(CURRENT_DATE, :period, 'MONTH') AS timestamp) " +
            "WHEN 'YEAR' THEN CAST(DATE_SUB(CURRENT_DATE, :period, 'YEAR') AS timestamp) " +
            "ELSE CURRENT_DATE " + // Default to today if unit is invalid
            "END")
     List<Order> findOrdersByPeriod(@Param("period") int period, @Param("unit") String unit);
}
