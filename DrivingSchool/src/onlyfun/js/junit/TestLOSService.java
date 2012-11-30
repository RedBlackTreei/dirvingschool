package onlyfun.js.junit;

import static org.junit.Assert.*;

import java.util.List;

import onlyfun.js.model.LocalOfSign;
import onlyfun.js.service.LocalOfSignService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 项目名称：DrivingSchool  
 * 类名称：TestLOSService  
 * 类描述：  
 * 创建人：js  
 * 创建时间：2012-11-30 上午9:15:53  
 * 修改人：js  
 * 修改时间：2012-11-30 上午9:15:53  
 * 修改备注：  
 * @version  
 */
public class TestLOSService {

	ApplicationContext context = null;
	LocalOfSignService loss = null;
	
	/**
	 * @throws java.lang.Exception
	 * void
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		loss = (LocalOfSignService)context.getBean("localOfSignServiceImpl");
	}

	/**
	 * @throws java.lang.Exception
	 * void
	 */
	@After
	public void tearDown() throws Exception {
		context = null;
		loss = null;
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#getLocalOfSignList()}.
	 */
	@Test
	public final void testGetLocalOfSignList() {
		List<LocalOfSign> los = loss.getLocalOfSignList();
		for (LocalOfSign localOfSign : los) {
			System.out.println(localOfSign.getName());
		}
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#getStockById(long)}.
	 */
	@Test
	public final void testGetStockById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#deleteLocalOfSign(onlyfun.js.model.LocalOfSign)}.
	 */
	@Test
	public final void testDeleteLocalOfSign() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#deleteLocalOfSignById(long)}.
	 */
	@Test
	public final void testDeleteLocalOfSignById() {
		loss.deleteLocalOfSignById(2);
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#addLocalOfSign(onlyfun.js.model.LocalOfSign)}.
	 */
	@Test
	public final void testAddLocalOfSign() {
		for (int i = 0; i < 3; i++) {
			LocalOfSign los = new LocalOfSign();
			los.setName("101驾校");
			los.setAddress("2#4-101");
			los.setTel("15280774223");
			loss.addLocalOfSign(los);
		}
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#updateLocalOfSign(onlyfun.js.model.LocalOfSign)}.
	 */
	@Test
	public final void testUpdateLocalOfSign() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#getLocalOfSignDao()}.
	 */
	@Test
	public final void testGetLocalOfSignDao() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.LocalOfSignServiceImpl#setLocalOfSignDao(onlyfun.js.dao.LocalOfSignDao)}.
	 */
	@Test
	public final void testSetLocalOfSignDao() {
		fail("Not yet implemented"); // TODO
	}

}
