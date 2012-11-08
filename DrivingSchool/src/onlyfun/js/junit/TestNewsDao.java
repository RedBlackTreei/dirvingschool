package onlyfun.js.junit;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import onlyfun.js.dao.NewsDao;
import onlyfun.js.model.News;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNewsDao {

	ApplicationContext context = null;
	NewsDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (NewsDao)context.getBean("newsDaoImpl");
	}
	
	@Test
	public void testGetNews(){
		List<News> news = dao.getNews();
		for(News n : news){
			System.out.println(n.getTitle());
		}
	}
	
	@Test
	public void testGetNewsById(){
		News news = dao.getNewsById(2);
		System.out.print(news.getTitle());
	}
	@Test
	public void testDeleteNews(){
		News news = dao.getNewsById(3);
		dao.deleteNews(news);
	}
	
	@Test
	public void testDeleteNewsById(){
		dao.deleteNewsById(4);
	}
	
	@Test
	public void testAddNews(){
		News n = new News();
		n.setTitle("日媒称日不能再依赖日美同盟 需在中美间中立");
		n.setContent("国际在线消息（记者 翟磊）：《日本经济新闻》日前发表文章认为，日本在中国崛起形势下不能再依赖日美同盟维护自身安全，需要在中美之间保持中立。文章说，过去60年间，美国主导了亚洲地区的安保体制。随着中国的快速崛起，这一时代已经终结。从趋势看，美国将不得不与中国在东亚分享权力。无论是中美对立，还是中美共治，对日本而言都是最糟糕的。日本要摆脱这一困境，唯一方法就是改变迄今依靠美国应对中国的做法，弱化日美同盟，强化对华关系，把日本拥有的的软、硬两方面资源巧妙运用到国防上。文章同时认为，虽然目前日本外交安全政策仍掌握在亲美派手中，但亚洲已进入新的时代，中美日三国正面临极为重要且无法回避的选择。日本身处中美两个大国的狭缝中，只能选择中立立场，与中美均保持良好关系，并确保自身行动自由。");
		n.setDate(format.format(new Date()));
		dao.addNews(n);
	}
	
	@Test
	public void testUpdate(){
		News news = dao.getNewsById(2);
		news.setTitle("日媒称日不能再过分依赖日美同盟 需在中美间中立");
		dao.update(news);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

}
