package onlyfun.js.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import onlyfun.js.model.News;
import onlyfun.js.service.NewsService;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class NewsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = -5249894395418739349L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private NewsService newsService;
	private News news;
	
	/*
	 * 方法的返回值，应为void，否则会出现很奇怪的问题
	 */
	public void getNewsList() throws Exception{
		List<News> newses = newsService.getNewsList();
		for (News news : newses) {
			System.out.println(news.getDate());
		}
		String json = JSONArray.fromObject(newses).toString();
		System.out.println("json-----"+json);
		this.response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(json);
		response.getWriter().flush();
	}
	
	@JSON(serialize=false)
	public NewsService getNewsService() {
		return newsService;
	}
	@Resource
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
