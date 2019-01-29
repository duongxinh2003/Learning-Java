package com.sonnh.myspringcrud;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.sonnh.myspringcrud.controller.UserController;
import com.sonnh.myspringcrud.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCrudControllerTests {
	
	@Autowired
	private UserController controller;
	
	@Mock
	private Model model;

	@Test
	public void navigateIndexPage() {
		assertEquals("Navigate index", "index", controller.index(model));
	}
	
	@Test
	public void navigateAddPage() {
		assertEquals("addUser", controller.addUser(model));
	}
	
	@Test
	public void navigateEditPage() {
		User expectedMock = Mockito.mock(User.class);
		Mockito.when(expectedMock.getId()).thenReturn((long) 10);
		Model modelMock = Mockito.mock(Model.class);
		Mockito.when(modelMock.addAttribute(("user"), expectedMock)).thenReturn(modelMock);
		assertEquals("editUser", controller.editUser(expectedMock.getId(), modelMock));
	}
}
