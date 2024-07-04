package com.example.vehicleservice.controller;

import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/healthchk")
    public String healthchk(){
        return "Vehicle Service Running";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> saveUser(@RequestBody VehicleDTO vehicleDTO){
        try {
            VehicleDTO vehicle = vehicleService.saveVehicle(vehicleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> updateUser(@RequestBody VehicleDTO vehicleDTO){
        try {
            VehicleDTO vehicle =vehicleService.updateVehicle(vehicleDTO);
            return ResponseEntity.status(HttpStatus.OK).body(vehicle);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> getUser(@PathVariable("id") String id){
        try {
            VehicleDTO vehicleDTO =vehicleService.getSelectedVehicle(id);
            return ResponseEntity.status(HttpStatus.OK).body(vehicleDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleDTO>> getAllUsers(){
        try {
            List<VehicleDTO> vehicleDTOS = vehicleService.getAllVehicle();
            return ResponseEntity.status(HttpStatus.OK).body(vehicleDTOS);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
