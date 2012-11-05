package onlyfun.js.junit.dao;


import java.text.SimpleDateFormat;
import java.util.List;

import onlyfun.js.dao.CoachDao;
import onlyfun.js.model.Coach;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCoachDao {
	
	ApplicationContext context = null;
	CoachDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (CoachDao)context.getBean("coachDaoImpl");
	}

	@Test
	public void testGetCoach(){
		List<Coach> coach = dao.getCoach();
		for(Coach c : coach){
			System.out.println(c.getName());
		}
	}
	
	@Test
	public void testGetCoachById(){
		Coach coach = dao.getCoachById(1);
			System.out.println(coach.getName());
	}
	
	@Test
	public void testGetCoachByUsername(){
		Coach coach = dao.getCoachByUsername("jishen21");
		if(coach==null)
			System.out.println("不存在此用戶！");
		else
			System.out.println(coach.getName());
	}
	
	@Test
	public void testUpdate(){
		Coach coach = dao.getCoachById(1);
		coach.setStuNum(3);
		dao.update(coach);
	}
	
	@Test
	public void testDeleteById(){
		dao.deleteCoachById(4);
	}
	
	@Test
	public void testAdd(){
		Coach coach = new Coach();
		coach.setName("比尔-盖茨");
		coach.setAddress("纽约-曼哈顿-16号");
		coach.setIdNum("341227198701282634");
		coach.setPassword("123");
		coach.setUsername("billgates");
		coach.setSex(true);
		coach.setStuFull(false);
		coach.setTel("15280774223");
		dao.addCoach(coach);
	}
	
	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

}
