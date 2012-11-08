package onlyfun.js.junit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import onlyfun.js.dao.StudyItemDao;
import onlyfun.js.model.StudyItems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudyItemsDao {

	ApplicationContext context = null;
	StudyItemDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (StudyItemDao) context.getBean("studyItemDaoImpl");
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

	@Test
	public void testGetStudyItems() {
		List<StudyItems> items = dao.getStudyItems();
		for (StudyItems studyItems : items) {
			System.out.println(studyItems.getItemName());
		}
	}

	@Test
	public void testGetStudyItemById() {
		StudyItems item = dao.getStudyItemById(3);
		assertEquals("科目3", item.getItemName());
	}

	@Test
	public void testUpdate() {
		StudyItems item = dao.getStudyItemById(3);
		item.setItemName("科目4");
		dao.update(item);
	}

	@Test
	public void testDeleteStudyItemById() {
		dao.deleteStudyItemById(5);
	}

	@Test
	public void testDeleteStudyItem() {
		StudyItems item = dao.getStudyItemById(6);
		dao.deleteStudyItem(item);
	}

	@Test
	public void testAddStudyItem() {
		StudyItems item = new StudyItems();
		item.setClassHour(96);
		item.setItemName("项目N");
		dao.addStudyItem(item);
	}

}
