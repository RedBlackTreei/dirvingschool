package onlyfun.js.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import onlyfun.js.dao.NewsDao;
import onlyfun.js.model.News;
import onlyfun.js.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao;
	
	public List<News> getNewsList() {
		return newsDao.getNews();
	}

	public void updateNews(long id) {
		News news = newsDao.getNewsById(id);
		newsDao.update(news);
	}

	public void deleteNews(long id) {
		newsDao.deleteNewsById(id);
	}

	public void addNews(News news) {
		newsDao.addNews(news);
	}

	public News getNews(long id) {
		return newsDao.getNewsById(id);
	}
	
	public void updateNews(News news) {
		newsDao.update(news);
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}
	
	@Resource
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
}
