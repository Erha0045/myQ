package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.Parameter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ParameterRepositoryTest {

    @Autowired
    ParameterRepository parameterRepository;

    @Test
    @Order(1)
    void testFindByTimeResolutionId() {
        List<Parameter> byTimeResolutionId = parameterRepository.findByTimeResolutionId(1L);
        Assertions.assertThat(byTimeResolutionId).isNotNull();
    }

}