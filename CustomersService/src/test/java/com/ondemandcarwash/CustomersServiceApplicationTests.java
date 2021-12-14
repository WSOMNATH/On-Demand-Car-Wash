package com.ondemandcarwash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ondemandcarwash.model.Customer;
import com.ondemandcarwash.repository.CustomerRepository;
import com.ondemandcarwash.service.CustomerService;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	class CustomersServiceApplicationTests {
	
		@Autowired
		private CustomerService service;
	
		@MockBean
		private CustomerRepository repository;

		@Test
		public void getCustomersTest() {
		when(repository.findAll()).thenReturn(Stream
					.of(new Customer(37, "Danile","546477","danial@gamil","USA","dany123"),
							new Customer(39, "Danile","546477","danial@gamil","USA","dany123"),
							new Customer(38, "Danile1","5464779","danial12@gamil","USA","dany123")).collect(Collectors.toList()));
			assertEquals(3, service.getCustomers().size());
		}
			
		@Test
		public void saveUserTest() {
			Customer customer = new Customer(37, "Danile","546477","danial@gamil","USA","dany123");
			when(repository.save(customer)).thenReturn(customer);
			assertEquals(customer, service.addCustomer(customer));
		}
	
		@Test
		public void deleteCustomerTest() {
			Customer customer = new Customer(37, "Danile","546477","danial@gamil","USA","dany123");	
			service.deleteCustomer(customer);
			verify(repository, times(1)).delete(customer);
		}
}
/*cId;
 cName;
cPhone;
cEmail;
 cAddress;
cPassword;*/