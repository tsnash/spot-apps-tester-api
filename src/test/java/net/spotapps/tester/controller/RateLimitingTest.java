package net.spotapps.tester.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class RateLimitingTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CacheManager cacheManager;

    @BeforeEach
    public void setUp() {
        cacheManager.getCache("rate-limit-buckets").clear();
    }

    @Test
    public void testRateLimiting() throws Exception {
        for (int i = 0; i < 10; i++) {
            mockMvc.perform(MockMvcRequestBuilders.get("/user-profiles")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print());
        }

        mockMvc.perform(MockMvcRequestBuilders.get("/user-profiles")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isTooManyRequests())
                .andDo(print());
    }

    @Test
    public void testRateLimitingOnSingleUserProfile() throws Exception {
        for (int i = 0; i < 10; i++) {
            mockMvc.perform(MockMvcRequestBuilders.get("/user-profiles/1")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andDo(print());
        }

        mockMvc.perform(MockMvcRequestBuilders.get("/user-profiles/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isTooManyRequests())
                .andDo(print());
    }
}
