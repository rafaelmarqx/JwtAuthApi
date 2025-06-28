package com.example.authserver;

import com.example.authserver.repository.UserRepository;
import com.example.authserver.service.JwtService;
import com.example.authserver.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(classes = AuthServerApplication.class)
@AutoConfigureMockMvc
public class AuthIntegrationTests {

    @Autowired private MockMvc mockMvc;
    @Autowired private JwtService jwtService;
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
    userRepository.deleteAll();

    userRepository.save(new User(null, "admin", passwordEncoder.encode("123456"), "ADMIN"));
    userRepository.save(new User(null, "user", passwordEncoder.encode("password"), "USER"));
    }

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(post("/auth/login")
                .param("username", "admin")
                .param("password", "123456")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
               .andExpect(status().isOk());
    }

    @Test
    void testAccessProtectedWithToken() throws Exception {
        String token = mockMvc.perform(post("/auth/login")
                .param("username", "user")
                .param("password", "password")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
               .andReturn().getResponse().getContentAsString();

        mockMvc.perform(get("/api/hello")
                .header("Authorization", "Bearer " + token))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Olá")));
    }
}
