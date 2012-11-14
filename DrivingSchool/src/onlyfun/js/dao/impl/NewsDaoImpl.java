package onlyfun.js.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.NewsDao;
import onlyfun.js.model.News;

/**
 * 新闻管理操作
 */
@Repository
public class NewsDaoImpl implements NewsDao {

	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public List<News> getNews() {
		@SuppressWarnings("unchecked")
		List<News> news = this.hibernateTemplate.find("from News");
		return news;
	}

	@Transactional
	public News getNewsById(long id) {
		News news = (News) this.hibernateTemplate.get(News.class, id);
		return news;
	}

	@Transactional
	public void update(News news) {
		this.hibernateTemplate.update(news);
	}

	@Transactional
	public void deleteNewsById(long newsId) {
		News news = this.getNewsById(newsId);
		this.hibernateTemplate.delete(news);
	}

	@Transactional
	public void deleteNews(News news) {
		this.hibernateTemplate.delete(news);

	}

	@Transactional
	public void addNews(News news) {
		this.hibernateTemplate.save(news);
	}

}
