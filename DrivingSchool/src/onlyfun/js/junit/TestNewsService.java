package onlyfun.js.junit;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import onlyfun.js.model.News;
import onlyfun.js.service.NewsService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNewsService {

	NewsService ns = null;
	ApplicationContext context = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ns = (NewsService)context.getBean("newsServiceImpl");
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		ns = null;
	}
	
	@Test
	public void testAddNews(){
		News news = new News();
		news.setTitle("");
		news.setContent("");
		news.setDate(format.format(new Date()));
		ns.addNews(news);
	}
	
	@Test
	public void testGetNews(){
		List<News> news = ns.getNewsList();
		for (News news2 : news) {
			System.out.println(news2.getTitle());
		}
	}
	
	@Test
	public void testGetNewsById(){
		News news = ns.getNews(1);
		System.out.println(news.getTitle());
	}
	
}
