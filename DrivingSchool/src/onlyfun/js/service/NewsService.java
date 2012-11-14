package onlyfun.js.service;

import java.util.List;

import onlyfun.js.model.News;

public interface NewsService {
	public List<News> getNewsList();

	public void updateNews(long id);

	public void deleteNews(long id);

	public void addNews(News news);

	public News getNews(long id);

	public void updateNews(News news);
}
