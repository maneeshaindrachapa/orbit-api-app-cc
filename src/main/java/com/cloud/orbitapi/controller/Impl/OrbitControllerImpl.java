package com.cloud.orbitapi.controller.Impl;

import com.cloud.orbitapi.controller.OrbitController;
import com.cloud.orbitapi.model.ModelApiResponse;
import com.cloud.orbitapi.model.Orbit;
import com.cloud.orbitapi.service.OrbitService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Api(tags = {"orbit"})
public class OrbitControllerImpl implements OrbitController {

    @Autowired
    private OrbitService orbitService;

    @Override
    public ResponseEntity<ModelApiResponse> controlOrbit(Orbit orbit) {

        if (orbitService.controlOrbit(orbit) > 0) {
            return new ResponseEntity<>(new ModelApiResponse(200, "", "Successfully updated the orbit"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ModelApiResponse(404, "", "Satellite not found"), HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Orbit> trackOrbit(Long satelliteID) {
        Optional<Orbit> orbit = orbitService.trackOrbit(satelliteID);
        return orbit.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new Orbit(), HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<Orbit>> getAllSatellites() {
        List<Orbit> orbits = orbitService.getAllOrbitDetails();
        if(orbits.size()>0){
            return (new ResponseEntity<>(orbits, HttpStatus.OK));
        }else{
            return (new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND));
        }
    }

}
