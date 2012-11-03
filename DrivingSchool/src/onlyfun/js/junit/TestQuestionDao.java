package onlyfun.js.junit;

import java.text.SimpleDateFormat;
import java.util.HashSet;
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
	public void testAddQuestion(){
		Question q = new Question();
		Set<QuestionItem> items = new HashSet<QuestionItem>();
		QuestionItem i1 = new QuestionItem();
		i1.setItem("是");
		QuestionItem i2 = new QuestionItem();
		i2.setItem("否");
		items.add(i1);
		items.add(i2);
		q.setTitle("机动车驾驶人的驾驶证未随身携带的，可以驾驶机动车?");
		q.setItems(items);
		dao.addQuestion(q);
	}
	
	@Test
	public void testGetQuestionById(){
		Question question = dao.getQuestionById(4);
		assertEquals("驾驶机动车看到这种标志需要注意什么？", question.getTitle());
	}
	
	@Test
	public void testUpdate(){
		Question q = dao.getQuestionById(6);
		q.setTitle("机动车驾驶人的驾驶证未随身携带的，可以驾驶机动车?");
		dao.update(q);
	}
	
	@Test
	public void testDeleteQuestionById(){
		Question q = dao.getQuestionById(5);
		dao.deleteQuesion(q);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}
}
