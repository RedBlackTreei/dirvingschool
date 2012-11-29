package onlyfun.js.service;

import java.util.List;

import onlyfun.js.model.Stock;

/**
 * 库存管理
 */
public interface StockService {
	/**
	 * 获取库存列表
	 * @return
	 * List<Stock>
	 */
	public List<Stock> getStockList();

	/**
	 * 通过物品id获取物品信息
	 * @param id 物品id
	 * @return
	 * Stock 获得的物品
	 */
	public Stock getStockById(long id);

	/**
	 * 删除库存物品
	 * @param stock
	 * void
	 */
	public void deleteStock(Stock stock);

	/**
	 * 通过id删除库存物品
	 * @param id
	 * void
	 */
	public void deleteStockById(long id);

	/**
	 * 添加物品
	 * @param stock
	 * void
	 */
	public void addStock(Stock stock);

	/**
	 * 更新物品
	 * @param stock
	 * void
	 */
	public void updateStock(Stock stock);
}
