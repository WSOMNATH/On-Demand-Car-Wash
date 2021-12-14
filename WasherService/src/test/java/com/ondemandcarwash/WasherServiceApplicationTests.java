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

import com.ondemandcarwash.model.Washer;
import com.ondemandcarwash.repository.WasherRepository;
import com.ondemandcarwash.service.WasherService;



@RunWith(SpringRunner.class)
@SpringBootTest
class WasherServiceApplicationTests {


@Autowired
private WasherService service;

@MockBean
private WasherRepository repository;

@Test
public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Washer(37, "Soma","soma@gmail.com","546474748","USA","soma123"),
						new Washer(37, "Sachin","sachin@gmail.com","623687878","MH","Sachin123")).collect(Collectors.toList()));
		assertEquals(2, service.getWashers().size());
	
	
	/* 	private int wId;
	private String wName;
	private String wEmail;
	private String wPhone;
	private String wAddress;
	private String wPassword;*/
}


@Test
public void saveUserTest() {
	Washer washer = new Washer(37, "Soma","soma@gmail.com","546474748","USA","soma123");
	when(repository.save(washer)).thenReturn(washer);
	assertEquals(washer, service.addWasher(washer));
}

@Test
public void deleteUserTest() {
	Washer washer = new Washer(37, "Soma","soma@gmail.com","546474748","USA","soma123");	
	service.deleteWasher(washer);
	verify(repository, times(1)).delete(washer);
}
}
