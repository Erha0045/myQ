package com.hovedopgave.myq.service;

import com.hovedopgave.myq.Entities.Parameter;
import com.hovedopgave.myq.Repositories.ParameterRepository;
import com.hovedopgave.myq.Services.ParameterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ParameterServiceTest {

    @InjectMocks
    ParameterService parameterService;

    @Mock
    ParameterRepository parameterRepository;

    @Test
    @DisplayName("Find By Time Resolution Id")
    void testFindByTime() {
        Mockito.when(parameterRepository.findByTimeResolutionId(ArgumentMatchers.anyLong()))
                .thenReturn(Collections.singletonList(new Parameter()));
        List<Parameter> byTime = parameterService.findByTime(1);
        Assertions.assertThat(byTime).isNotNull();
        Assertions.assertThat(byTime).isNotEmpty();
    }
}
