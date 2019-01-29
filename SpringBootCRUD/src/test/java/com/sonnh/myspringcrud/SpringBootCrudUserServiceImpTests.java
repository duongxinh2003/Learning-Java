package com.sonnh.myspringcrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import com.sonnh.myspringcrud.entity.User;
import com.sonnh.myspringcrud.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCrudUserServiceImpTests {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * Test getAllUser() function
	 */
	@Test
	public void whenGetAllUser_thenReturnNotNull() {
		List<User> actualList = userServiceImpl.getAllUser();
		assertNotNull("expected not null", actualList);
	}
	
	@Test
	public void whenGetAllUser_thenReturnList() {
		List<User> actualList = userServiceImpl.getAllUser();
		assertNotEquals(null, actualList.size());
	}
	/**
	 * Test saveUser() function
	 */
	@Test
	public void whenSaveUserSuccess_thenResultUserByName() {
		User expected = new User("expected", "expected@gmail.com", "01234567890");
		userServiceImpl.saveUser(expected);
		List<User> actual = userServiceImpl.findUserByName("expected");
		assertNotEquals(0, actual.size());
	}
	
	@Test(expected=Exception.class)
	public void saveUserButNullParameter_thenThrowsException() {
		userServiceImpl.saveUser(null);
	}
	
	/**
	 * Test delete user by Id
	 */
	
	@Test(expected = EmptyResultDataAccessException.class)
	public void deleteUser_IsExist() {
		userServiceImpl.deleteUser(new Long(29));
		userServiceImpl.findUserById(new Long(29));
	}
	
	/**
	 * Test find user by id
	 */
	@Test
	public void whenFindUserById_thenReturnOptionalUser() {
		Optional<User> actual = userServiceImpl.findUserById(new Long(1));
		User expected = Mockito.mock(User.class);
		Mockito.when(expected.getName()).thenReturn("NvA");
		assertEquals(expected.getName(), actual.get().getName());
	}
}

