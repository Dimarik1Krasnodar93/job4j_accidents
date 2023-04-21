package ru.job4j.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.Main;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class AccidentControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccidentService accidentService;



    @Test
    @WithMockUser
    public void getAllAccidents() throws Exception {
        this.mockMvc.perform(get("/accidents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("accidents"));

    }

    @Test
    @WithMockUser
    public void createAccident() throws Exception {
        this.mockMvc.perform(get("/createAccident"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("createAccident"));
    }

    @Test
    @WithMockUser
    public void formUpdateAccident() throws Exception {
        this.mockMvc.perform(get("/formUpdateAccident?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("updateAccident"));
    }

    @Test
    @WithMockUser
    public void save() throws Exception {
        String [] array = new String[1];
        array[0] = "1";
        this.mockMvc.perform(post("/saveAccident")
                        .param("name", "Инцидент1")
                        .param("type.id", "1")
                        .param("rIds",array)
                )
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Accident> argument = ArgumentCaptor.forClass(Accident.class);
        verify(accidentService).create(argument.capture());
        assertThat(argument.getValue().getName()).isEqualTo("Инцидент1");
    }

    @Test
    @WithMockUser
    public void update() throws Exception {
        String [] array = new String[1];
        array[0] = "1";
        this.mockMvc.perform(post("/updateAccident")
                        .param("name", "Инцидент1")
                        .param("type.id", "1")
                )
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Accident> argument = ArgumentCaptor.forClass(Accident.class);
        verify(accidentService).update(argument.capture());
        assertThat(argument.getValue().getName()).isEqualTo("Инцидент1");
    }

}