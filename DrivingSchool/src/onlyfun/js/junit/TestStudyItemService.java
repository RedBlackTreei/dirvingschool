package onlyfun.js.junit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import onlyfun.js.model.StudyItems;
import onlyfun.js.service.StudyItemsService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 项目名称：DrivingSchool  
 * 类名称：TestStudyItemService  
 * 类描述：  StudyItemsServiceImpl测试类
 * 创建人：js  
 * 创建时间：2012-11-16 上午8:52:11  
 * 修改人：js  
 * 修改时间：2012-11-16 上午8:52:11  
 * 修改备注：  
 * @version  
 */
public class TestStudyItemService {

	/**
	 * @throws java.lang.Exception
	 * void
	 */
	StudyItemsService ss = null;
	ApplicationContext context = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ss = (StudyItemsService) context.getBean("studyItemsServiceImpl");
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		ss = null;
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#getStudyItems()}.
	 */
	@Test
	public final void testGetStudyItems() {
		List<StudyItems> items = ss.getStudyItems();
		for (StudyItems studyItems : items) {
			System.out.println(studyItems.getItemName());
		}
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#getStudyItems(long)}.
	 */
	@Test
	public final void testGetStudyItemsLong() {
		StudyItems item = ss.getStudyItems(1);
		item.getCoach();
		System.out.println(item.getItemName());
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#addStudyItems(onlyfun.js.model.StudyItems)}.
	 */
	@Test
	public final void testAddStudyItems() {
		StudyItems items = new StudyItems();
		items.setItemName("项目4");
		items.setClassHour(36);
		ss.addStudyItems(items);
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#deleteStudyItems(long)}.
	 */
	@Test
	public final void testDeleteStudyItems() {
		ss.deleteStudyItems(4);
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#update(onlyfun.js.model.StudyItems)}.
	 */
	@Test
	public final void testUpdateStudyItems() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#update(long)}.
	 */
	@Test
	public final void testUpdateLong() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#getStudyItemDao()}.
	 */
	@Test
	public final void testGetStudyItemDao() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StudyItemsServiceImpl#setStudyItemDao(onlyfun.js.dao.StudyItemDao)}.
	 */
	@Test
	public final void testSetStudyItemDao() {
		fail("Not yet implemented"); // TODO
	}

}
