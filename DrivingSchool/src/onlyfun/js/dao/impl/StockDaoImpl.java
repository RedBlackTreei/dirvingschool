package onlyfun.js.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.StockDao;
import onlyfun.js.model.Stock;

@Repository
public class StockDaoImpl implements StockDao {

	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public List<Stock> getStock() {
		@SuppressWarnings("unchecked")
		List<Stock> stocks = this.hibernateTemplate.find("from Stock");
		return stocks;
	}

	@Transactional
	public Stock getStockById(long id) {
		Stock stock = (Stock) this.hibernateTemplate.get(Stock.class, id);
		return stock;
	}

	@Transactional
	public void update(Stock stock) {
		this.hibernateTemplate.update(stock);

	}

	@Transactional
	public void deleteStockById(long stockId) {
		Stock stock = (Stock) this.hibernateTemplate.get(Stock.class, stockId);
		this.hibernateTemplate.delete(stock);

	}

	@Transactional
	public void deleteStock(Stock stock) {
		this.hibernateTemplate.delete(stock);
	}

	@Transactional
	public void addStock(Stock stock) {
		this.hibernateTemplate.save(stock);

	}

}
