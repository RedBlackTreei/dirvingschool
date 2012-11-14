package onlyfun.js.junit;

import onlyfun.js.model.Coach;
import onlyfun.js.model.Person;
import onlyfun.js.model.Student;
import onlyfun.js.service.UserService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

	UserService us = null;
	ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		us = (UserService) context.getBean("userServiceImpl");
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		us = null;
	}

	@Test
	public void testLogin() {
		// assertEquals(true, us.login("ji", "101", "student"));
		// assertEquals(true, us.login("jishen521", "101", "coach"));
		// assertEquals(true, us.login("admin", "101", "person"));
		System.out.println("学生---" + us.login("ji", "101", "student"));
		System.out.println("教练---" + us.login("jishen521", "101", "coach"));
		System.out.println("管理员---" + us.login("admin", "101", "person"));
	}

	@Test
	public void testSetInfo() {
		Person p = us.getInfo("person", "person");
		p.setName("person0");
		us.setInfo(p, "person");
		Coach c = (Coach) us.getInfo("coach", "coach");
		c.setName("coach0");
		us.setInfo(c, "coach");
		Student stu = (Student) us.getInfo("student", "studnet");
		stu.setName("studnet0");
		us.setInfo(stu, "student");
	}

	@Test
	public void testGetInfo() {
		Person p = us.getInfo("person", "person");
		System.out.println(p.getName());

		Coach c = (Coach) us.getInfo("coach", "coach");
		System.out.println(c.getStuNum());

		Student stu = (Student) us.getInfo("student", "studnet");
		System.out.println(stu.getSchoolTime());
	}

	@Test
	public void testAddUser() {
		Person p = new Person();
		p.setUsername("person");
		p.setPassword("101");
		p.setName("person");

		Coach coach = new Coach();
		coach.setUsername("coach");
		coach.setPassword("101");
		coach.setName("coach");

		Student stu = new Student();
		stu.setUsername("student");
		stu.setPassword("101");
		stu.setName("student");

		us.addUser(stu, "student");
		us.addUser(coach, "coach");
		us.addUser(p, "person");
	}

}
