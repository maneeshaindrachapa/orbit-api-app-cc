package com.cloud.orbitapi.service;

import com.cloud.orbitapi.model.Orbit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrbitService {

    int controlOrbit(Orbit orbit);

    Optional<Orbit> trackOrbit(Long satelliteID);

    List<Orbit> getAllOrbitDetails();
}
