package com.app.controller;
import com.app.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.app.model.*;
import com.app.service.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getCustomerOrders(customerId));
    }
    @PreAuthorize("hasAuthority('CUSTOMER')") // Or whatever roles have access
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Long id) {
        try {
            Order order = orderService.getOrderDetails(id);
            if (order != null) {
                return ResponseEntity.ok(order);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PreAuthorize("hasRole('DRIVER')")
    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<Order>> getDriverOrders(@PathVariable Long driverId) {
        return ResponseEntity.ok(orderService.getDriverOrders(driverId));
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping("/place")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PatchMapping("/{orderId}/assign/{driverId}")
    public ResponseEntity<Order> assignDriver(@PathVariable Long orderId, @PathVariable Long driverId) {
        return ResponseEntity.ok(orderService.assignDriver(orderId, driverId));
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PatchMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.cancelOrder(orderId));
    }

    @PreAuthorize("hasRole('DRIVER')")
    @PatchMapping("/{orderId}/complete")
    public ResponseEntity<Order> completeOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.completeOrder(orderId));
    }
}
