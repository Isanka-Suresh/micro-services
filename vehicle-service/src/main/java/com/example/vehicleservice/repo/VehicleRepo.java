package com.example.vehicleservice.repo;

import com.example.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
