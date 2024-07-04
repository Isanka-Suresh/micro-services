package com.example.vehicleservice.service;

import com.example.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle (VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicleId);
    VehicleDTO getSelectedVehicle(String vehicleId);
    List<VehicleDTO> getAllVehicle();
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
}
