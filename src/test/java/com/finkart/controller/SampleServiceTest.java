package com.finkart.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.finkart.entity.User;
import com.finkart.service.SampleService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames= "com.finkart.*")
public class SampleServiceTest {

	@InjectMocks
	SampleService sampleService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(SampleService.class);
	}
	
	@Test
	public void userDetailsTest() throws Exception{
		// When
		SampleService spy = PowerMockito.spy(sampleService);
		List<User> usrList = new ArrayList<User>();
		User user = new User();
		user.setId(1l);
		user.setFirstName("test");
		usrList.add(user);
		
		PowerMockito.doReturn(usrList).when(spy, "userList");

		//Then
		List<User> uList = spy.userDetails();
		
		assertEquals(usrList.get(0).getFirstName(), uList.get(0).getFirstName());
		
	}

}
