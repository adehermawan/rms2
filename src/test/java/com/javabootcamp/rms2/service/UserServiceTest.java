package com.javabootcamp.rms2.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javabootcamp.rms2.model.User;
import com.javabootcamp.rms2.repository.RoleRepo;
import com.javabootcamp.rms2.repository.UserRepo;

public class UserServiceTest {
	
	@Mock
	private UserRepo mockUserRepo;
	@Mock
	private RoleRepo mockRoleRepo;
	@Mock
	private BCryptPasswordEncoder mockBCryptPasswordEncoder;
	
	private UserService userServiceTest;
	private User user;
	
	@Before
	public void setUp() {
		initMocks(this);
		userServiceTest = new UserService(mockUserRepo, mockRoleRepo, mockBCryptPasswordEncoder);
		
		user = user.builder()
				.id(1)
				.name("Ade")
				.lastName("Hermawan")
				.email("hi@ade.com")
				.build();
		
		Mockito.when(mockUserRepo.save(any()))
		.thenReturn(user);
		Mockito.when(mockUserRepo.findByEmail(anyString()))
		.thenReturn(user);
		
	}
	
	@Test
	public void testFindUserByEmail() {
		
		final String email = "test@google.com";
		
		final User result = userServiceTest.findUserByEmail(email);
		
		assertEquals(email,result.getEmail());
	}
	
	@Test
	public void testSaveUser() {
		
		final String email = "ade@facebook.com";
		
		User result = userServiceTest.saveUser(User.builder().build());
		
		assertEquals(email,result.getEmail());
		
	}
	

}
