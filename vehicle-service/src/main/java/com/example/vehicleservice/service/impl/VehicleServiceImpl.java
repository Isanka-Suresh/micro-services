package com.example.vehicleservice.service.impl;

import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.entity.Vehicle;
import com.example.vehicleservice.repo.VehicleRepo;
import com.example.vehicleservice.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class)), VehicleDTO.class);
    }

    @Override
    public void deleteVehicle(String vehicleId) {

    }

    @Override
    public VehicleDTO getSelectedVehicle(String vehicleId) {
        return modelMapper.map(vehicleRepo.findById(vehicleId), VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return modelMapper.map(vehicleRepo.findAll(), List.class);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class)), VehicleDTO.class);
    }
}
