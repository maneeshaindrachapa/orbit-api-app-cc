package com.cloud.orbitapi.controller;

import com.cloud.orbitapi.model.ModelApiResponse;
import com.cloud.orbitapi.model.Orbit;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "orbit")
public interface OrbitController {

    @ApiOperation(value = "Control the Orbit", nickname = "controlOrbit", notes = "Returns the status", response = ModelApiResponse.class, tags = {"orbit",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = ModelApiResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = ModelApiResponse.class)})
    @RequestMapping(value = "/orbit/control",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<ModelApiResponse> controlOrbit(@RequestBody Orbit orbit);


    @ApiOperation(value = "Track the Orbit of the satellite", nickname = "trackOrbit", notes = "Returns the status", response = Orbit.class, tags = {"orbit",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Orbit.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = ModelApiResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = ModelApiResponse.class)})
    @RequestMapping(value = "/orbit/track/{satelliteID}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Orbit> trackOrbit(@ApiParam(value = "Satellite ID", required = true)
                                     @PathVariable("satelliteID") Long satelliteID);

    @ApiOperation(value = "Get all Orbit Details", nickname = "getAllOrbits", notes = "Returns all Orbits", response = Orbit.class, tags = {"orbit",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Orbit.class),
            @ApiResponse(code = 404, message = "Orbits not found", response = ModelApiResponse.class)})
    @RequestMapping(value = "/orbit/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Orbit>> getAllSatellites();
}
