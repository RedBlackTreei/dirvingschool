package onlyfun.js.junit.service;


import java.text.SimpleDateFormat;

import onlyfun.js.dao.CoachDao;
import onlyfun.js.dao.PersonDao;
import onlyfun.js.dao.StudentDao;
import onlyfun.js.model.Coach;
import onlyfun.js.model.Person;
import onlyfun.js.model.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

	ApplicationContext context = null;
	CoachDao coachDao = null;
	StudentDao stuDao = null;
	PersonDao personDao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		coachDao = (CoachDao) context.getBean("coachDaoImpl");
		stuDao = (StudentDao)context.getBean("studentDaoImpl");
		personDao = (PersonDao)context.getBean("personDaoImpl");
		
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		coachDao = null;
		stuDao = null;
		personDao = null;
	}
	
	@Test
	public void testLogin(){
		String username = "admin";
		String password = "101";
		Person student = (Student)stuDao.getStuByUsername(username);
		Person coach = (Coach)coachDao.getCoachByUsername(username);
		Person person = (Person)personDao.getPersonByUsername(username);
		if(student==null&&coach==null&&person==null){
			System.out.println("该用户不存在");
		}
		if(student!=null){
			System.out.println("学生-->"+student.getName());
			System.out.println(student.getPassword().equals(password)?"登录成功！":"密码错误");
			return;
		}
		if(coach!=null){
			System.out.println("教练-->"+coach.getName());
			System.out.println(coach.getPassword().equals(password)?"登录成功！":"密码错误");
			return;
		}
		if(person!=null){
			System.out.println("管理员-->"+person.getName());
			System.out.println(person.getPassword().equals(password)?"登录成功！":"密码错误");
			return;
		}
	}

}
