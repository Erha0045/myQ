package com.hovedopgave.myq.service;

import com.hovedopgave.myq.Entities.QueTask;
import com.hovedopgave.myq.Repositories.QueRepository;
import com.hovedopgave.myq.Services.QueService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QueServiceTest {

    @InjectMocks
    QueService queService;

    @Mock
    QueRepository queRepository;

    @Test
    void testRetryQueTask() {
        QueTask queTask = new QueTask();
        queTask.setId(1);
        queTask.setUsername("prove");
        queTask.setDependsOn(1L);
        queTask.setStatus(3);
        queTask.setNumTries(0);
        Mockito.when(queRepository.getById(ArgumentMatchers.anyLong())).thenReturn(queTask);
        queService.retryQueTask(queTask.getId());
        Assertions.assertThat(queTask.getStatus()).isEqualTo(0);
        Assertions.assertThat(queTask.getNumTries()).isGreaterThan(0);
    }
}
