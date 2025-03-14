package com.app.service;


import com.app.model.*;

import com.app.repo.OrderRepository;
import com.app.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

   
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public List<Order> getCustomerOrders(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }


    public List<Order> getDriverOrders(Long driverId) {
        return orderRepository.findByDriverId(driverId);
    }


    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        if (order.getStatusHistory() != null) {
            for (StatusHistory status : order.getStatusHistory()) {
                status.setOrder(order); // Set the order reference explicitly
            }
        }
        return orderRepository.save(order);
    }

    
    public Order assignDriver(Long orderId, Long driverId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() != OrderStatus.CONFIRMED) {
            throw new RuntimeException("Order must be CONFIRMED before assigning a driver");
        }

        User user = userRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!"DRIVER".equals(user.getRole().toString())) {
            throw new RuntimeException("User is not a driver");
        }

        // Corrected type casting and instance check
        if (user instanceof Driver) {
            order.setDriver((Driver) user);
        } else {
            throw new RuntimeException("User is not a valid Driver.");
        }

        order.setStatus(OrderStatus.ASSIGNED);
        return orderRepository.save(order);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() == OrderStatus.COMPLETED) {
            throw new RuntimeException("Cannot cancel a completed order");
        }

        order.setStatus(OrderStatus.CANCELED);
        return orderRepository.save(order);
    }
    public Order getOrderDetails(Long orderId) {
    	 Order order = orderRepository.getById(orderId);
    	 return order;
    }
    public Order completeOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() != OrderStatus.ASSIGNED) {
            throw new RuntimeException("Only ASSIGNED orders can be completed");
        }

        order.setStatus(OrderStatus.COMPLETED);
        return orderRepository.save(order);
    }
}
