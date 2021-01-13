package com.cloud.orbitapi.component;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class DemoData implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(DemoData.class);

    @Autowired
    private EntityManager entityManager;

    Query query;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        query = entityManager.createNativeQuery("SELECT COUNT(*) FROM orbit");
        BigInteger result = (BigInteger) query.getSingleResult();
        if (result.intValue() <= 1) {
            query = entityManager.createNativeQuery("INSERT INTO orbit (satellite_id, latitude, longitude) VALUES (1, 35.929673, -78.948237), ('2', 38.889510, -77.032000), " +
                    "('3', 38.032120, -78.477510), ('4', 36.379450, -75.830290);");
            query.executeUpdate();
        }
    }
}