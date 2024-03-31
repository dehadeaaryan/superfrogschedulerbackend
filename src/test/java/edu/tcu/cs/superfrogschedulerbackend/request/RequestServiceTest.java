package edu.tcu.cs.superfrogschedulerbackend.request;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {
    @Mock
    RequestRepository requestRepository;
    @InjectMocks
    RequestService requestService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testFindByIdSuccess() {
        // Given


        // When


        // Then

    }
}
