package onlyfun.js.junit;


import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;
import onlyfun.js.dao.LocalOfSignDao;
import onlyfun.js.model.LocalOfSign;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLocalOfSignDao {

	ApplicationContext context = null;
	LocalOfSignDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (LocalOfSignDao)context.getBean("localOfSignDaoImpl");
	}
	
	@Test
	public void testGetLocalOfSignList(){
		List<LocalOfSign> locals = dao.getLocal();
		for(LocalOfSign s : locals){
			System.out.println(s.getAddress());
		}
	}
	
	@Test
	public void testGetLocalById(){
		LocalOfSign local = dao.getLocalById(2);
		System.out.println(local.getAddress());
	}
	
	@Test
	public void testUpdate(){
		LocalOfSign local = dao.getLocalById(1);
		local.setTel("15280774223");
		dao.updateLocal(local);
		assertEquals("15280774223", local.getTel());
	}
	
	@Test
	public void testDeleteById(){
		dao.deleteLocalById(4);
	}
	
	@Test
	public void testDelete(){
		LocalOfSign local = dao.getLocalById(3);
		dao.deleteLocal(local);
	}
	
	@Test
	public void testAdd(){
		LocalOfSign local = new LocalOfSign();
		local.setAddress("亳州利辛");
		local.setName("利辛驾校");
		local.setTel("13665382346");
		dao.addLocal(local);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

}
