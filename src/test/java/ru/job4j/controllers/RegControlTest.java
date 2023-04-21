package ru.job4j.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class RegControlTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void save() throws Exception {
        this.mockMvc.perform(post("/reg")
                                .param("password", "test1p")
                .param("username", "test12104")
                ).andDo(print())
                .andExpect(status().is3xxRedirection());
    }
}