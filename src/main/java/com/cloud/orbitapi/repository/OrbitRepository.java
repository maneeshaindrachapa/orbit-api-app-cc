package com.cloud.orbitapi.repository;

import com.cloud.orbitapi.model.Orbit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrbitRepository extends JpaRepository<Orbit, Long> {

    @Modifying
    @Transactional
    @Query("update Orbit ob set ob.latitude = :latitude, ob.longitude = :longitude where ob.satellite_id = :satelliteID")
    int updateOrbit(Long satelliteID, BigDecimal latitude, BigDecimal longitude);

    Optional<Orbit> findById(Long satelliteID);

    List<Orbit> findAll();
}