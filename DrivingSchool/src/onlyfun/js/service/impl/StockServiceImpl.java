package onlyfun.js.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import onlyfun.js.dao.StockDao;
import onlyfun.js.model.Stock;
import onlyfun.js.service.StockService;

/**
 * 库存管理
 * @version  
 */
@Service
public class StockServiceImpl implements StockService {

	private StockDao stockDao;

	@Override
	public List<Stock> getStockList() {
		List<Stock> stocks = this.stockDao.getStock();
		return stocks;
	}

	@Override
	public Stock getStockById(long id) {
		return this.stockDao.getStockById(id);
	}

	@Override
	public void deleteStock(Stock stock) {
		this.stockDao.deleteStock(stock);
	}

	@Override
	public void deleteStockById(long id) {
		this.stockDao.deleteStockById(id);

	}

	@Override
	public void addStock(Stock stock) {
		this.stockDao.addStock(stock);

	}

	@Override
	public void updateStock(Stock stock) {
		this.stockDao.update(stock);

	}

	public StockDao getStockDao() {
		return stockDao;
	}

	@Resource
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}
}
