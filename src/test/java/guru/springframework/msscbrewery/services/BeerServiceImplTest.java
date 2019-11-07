package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class BeerServiceImplTest {

    private BeerServiceImpl beerService = new BeerServiceImpl();
    @Test
    public void testGetRandomBeer() {
        BeerDto randomBeer = beerService.getRandomBeer();
        assertNotNull(randomBeer.getId());
        assertEquals("Goldstar", randomBeer.getBeerName());
    }

}