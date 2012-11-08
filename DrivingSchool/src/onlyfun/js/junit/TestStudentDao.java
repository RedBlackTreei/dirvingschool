package onlyfun.js.junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import onlyfun.js.dao.StudentDao;
import onlyfun.js.model.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentDao {

	ApplicationContext context = null;
	StudentDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (StudentDao) context.getBean("studentDaoImpl");
	}
	
	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

	@Test
	public void testGetStudent() {
		List<Student> stus = dao.getStudent();
		for (Student student : stus) {
			System.out.println(student.getName());
		}
	}

	@Test
	public void testGetStudentById() {
		dao.getStudentById(3);
		System.out.println(dao.getStudentById(3).getName());
	}

	@Test
	public void testUpdate() {
		Student stu = dao.getStudentById(3);
		stu.setName("青竹");
		dao.update(stu);
	}

	@Test
	public void testDeleteStudent() {
		Student stu = dao.getStudentById(4);
		dao.deleteStudent(stu);
	}

	@Test
	public void testDeleteStudentById() {
		dao.deleteStudentById(5);
	}
	
	@Test
	public void testGetStudentByUsername(){
		Student stu = dao.getStuByUsername("w1u");
		if(stu==null)
			System.out.println("不存在此用戶");
		else
			System.out.println(stu.getName());
	}

	@Test
	public void testAddStudent() {
		Student stu = new Student();
		stu.setName("墨水");
		stu.setAddress("2-3#301");
		stu.setIdNum("2138412384081203498");
		stu.setSex(true);
		stu.setDateOfEntry(format.format(new Date()));
		stu.setTel("12388347876");
		stu.setUsername("ji");
		stu.setPassword("101");
		stu.setFinshedSub(3);
		stu.setPayfee(true);
		stu.setSchoolTime("8");
		dao.addStudent(stu);
	}
	
	@Test
	public void login(){
		System.out.println(dao.login("wu", "102"));
	}
	
	@Test
	public void testExist(){
		System.out.println(dao.isExist("ji"));
	}

}
