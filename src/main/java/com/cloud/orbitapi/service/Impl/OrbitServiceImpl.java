package com.cloud.orbitapi.service.Impl;

import com.cloud.orbitapi.model.Orbit;
import com.cloud.orbitapi.repository.OrbitRepository;
import com.cloud.orbitapi.service.OrbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrbitServiceImpl implements OrbitService {

    @Autowired
    private OrbitRepository orbitRepository;

    @Override
    public int controlOrbit(Orbit orbit) {
        return orbitRepository.updateOrbit(orbit.getSatellite_id(), orbit.getLatitude(), orbit.getLongitude());
    }

    @Override
    public Optional<Orbit> trackOrbit(Long satelliteID) {
        return orbitRepository.findById(satelliteID);
    }

    @Override
    public List<Orbit> getAllOrbitDetails() {
        return orbitRepository.findAll();
    }

}
