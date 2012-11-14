package onlyfun.js.junit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import onlyfun.js.dao.PersonDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonDao {

	ApplicationContext context = null;
	PersonDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (PersonDao) context.getBean("personDaoImpl");
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

	@Test
	public void testGetPersonByUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersonById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExist() {
		assertEquals(true, dao.isExist("admin"));
	}

	@Test
	public void testLogin() {
		assertEquals(true, dao.login("admin", "101"));
	}

}
