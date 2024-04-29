package edu.tcu.cs.superfrogschedulerbackend.security;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Security;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.tcu.cs.superfrogschedulerbackend.request.RequestService;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SecurityConfig securityConfig;

    @Before
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("user", "password");
        base = new URL("http://localhost:" + port);
    }
    
    @Test
    void testPasswordEncoder() {

    }

    @Test
    void testSecurityFilterChain() {

    }

    @Test
    void testUsers() {

    }
}
