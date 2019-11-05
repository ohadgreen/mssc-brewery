package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().customerId(UUID.randomUUID()).name("John Biryon").build();
    }

    @Override
    public CustomerDto getRandomCustomer() {
        return CustomerDto.builder().customerId(UUID.randomUUID()).name("Hillie Billie").build();
    }
}
