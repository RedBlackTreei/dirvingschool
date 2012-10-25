package onlyfun.js.junit;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;
import onlyfun.js.dao.QuestionDao;
import onlyfun.js.model.Question;
import onlyfun.js.model.QuestionItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuestionDao {
	ApplicationContext context = null;
	QuestionDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (QuestionDao)context.getBean("questionDaoImpl");
	}
	
	@Test
	public void testGetQuestions(){
		List<Question> questions = dao.getQuestions();
		for (Question question : questions) {
			System.out.println(question.getTitle());
			Set<QuestionItem> qt = question.getItems();
			int i=0;
			for (QuestionItem questionItem : qt) {
				System.out.println((char)(65+i) + "." + questionItem.getItem());
				i++;
			}
		}
	}
	
	@Test
	public void testGetQuestionById(){
		Question question = dao.getQuestionById(4);
		assertEquals("驾驶机动车看到这种标志需要注意什么？", question.getTitle());
	}
	
	@Test
	public void testUpdate(){
		
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}
}
