package com.app.service;

import com.app.model.Driver;

import com.app.repo.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<Driver> getAvailableDrivers() {
        return driverRepository.findByIsAvailableTrue();
    }

    public List<Driver> getTopPerformingDrivers(int limit) {
        return driverRepository.findTop10ByOrderByRatingDescCompletedDeliveriesDesc();
    }

    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public Driver updateDriverLocation(Long driverId, double latitude, double longitude) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        driver.setLatitude(latitude);
        driver.setLongitude(longitude);
        return driverRepository.save(driver);
    }

    public Driver updateDriverAvailability(Long driverId, boolean isAvailable) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        driver.setIsAvailable(isAvailable);
        return driverRepository.save(driver);
    }
}
