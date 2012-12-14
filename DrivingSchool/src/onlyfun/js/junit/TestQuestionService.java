package onlyfun.js.junit;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import onlyfun.js.model.Question;
import onlyfun.js.model.QuestionItem;
import onlyfun.js.service.QuestionService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuestionService {

	private ApplicationContext context;
	private QuestionService questionService;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		questionService = (QuestionService)context.getBean("questionServiceImpl");
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		questionService = null;
	}

	@Test
	public void testGetQuestions() {
		List<Question> q = this.questionService.getQuestions();
		for (Question question : q) {
			System.out.println(question.getTitle());
//			Set<QuestionItem> items = question.getItems();
//			for (Iterator iterator = items.iterator(); iterator.hasNext();) {
//				QuestionItem questionItem = (QuestionItem) iterator.next();
//				System.out.println(questionItem.getItem());
//			}
		}
		String j = JSONObject.fromObject(q).toString();
		
		System.out.println(j);
	}

	@Test
	public void testAddQuestion() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteQuestionById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteQuestioon() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateQuestion() {
		fail("Not yet implemented");
	}

}
