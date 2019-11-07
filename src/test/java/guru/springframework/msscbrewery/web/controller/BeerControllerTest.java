package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerServiceImpl;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BeerControllerTest {

    @Mock
    BeerServiceImpl beerService;

    @InjectMocks
    BeerController beerController;

    private MockMvc mockMvc;

    private BeerDto testBeer;
    private final UUID uuid = UUID.fromString("e4d910b7-7d7f-4460-abf8-92c373a41884");

    @BeforeEach
    void setUp() {
        testBeer = BeerDto.builder()
                .id(uuid)
                .beerName("Maccabi")
                .beerStyle("Lager")
                .build();
        mockMvc = MockMvcBuilders.standaloneSetup(beerController).build();
    }

    @Test
    void getBeerByIdTest() throws Exception {
        when(beerService.getBeerById(any())).thenReturn(testBeer);
        mockMvc.perform(get("/api/v1/beer/" + uuid))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.beerName").value(testBeer.getBeerName()));
    }
}