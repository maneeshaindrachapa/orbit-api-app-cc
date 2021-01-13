package com.cloud.orbitapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orbit")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Orbit {

    @Id
    @JsonProperty("satellite_id")
    @Column(name = "satellite_id", nullable = false)
    private Long satellite_id;

    @JsonProperty("latitude")
    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @JsonProperty("longitude")
    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

}
