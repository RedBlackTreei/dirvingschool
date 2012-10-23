package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Stock;

/*
 * 库存管理
 */
public interface StockDao {
	/*
	 * 获取所有库存物品
	 */
	public List<Stock> getStock();
	
	/*
	 * 通过id获取库存物品
	 */
	public Stock getStockById(long id);
	
	/*
	 * 更新库存物品
	 */
	public void update(long stockId);
	
	/*
	 * 删除库存物品
	 */
	public void deleteStock(long stockId);
	
	/*
	 * 添加库存物品
	 */
	public void addStock(Stock stock);
}
