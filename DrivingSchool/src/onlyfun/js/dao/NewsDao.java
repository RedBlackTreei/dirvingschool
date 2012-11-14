package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.News;

/**
 * 新闻管理操作
 */
public interface NewsDao {
	/**
	 * 获取所有新闻
	 */
	public List<News> getNews();

	/**
	 * 通过id获取新闻
	 */
	public News getNewsById(long id);

	/**
	 * 更新新闻
	 */
	public void update(News news);

	/**
	 * 删除新闻
	 */
	public void deleteNewsById(long newsId);

	/**
	 * 删除新闻
	 */
	public void deleteNews(News news);

	/**
	 * 添加新闻
	 */
	public void addNews(News news);
}
