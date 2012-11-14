/**
 * 
 */
package onlyfun.js.junit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import onlyfun.js.dao.StockDao;
import onlyfun.js.model.Stock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author administrator
 * 
 */
public class TestStockDao {

	/**
	 * @throws java.lang.Exception
	 */
	ApplicationContext context = null;
	StockDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (StockDao) context.getBean("stockDaoImpl");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

	/**
	 * Test method for {@link onlyfun.js.dao.impl.StockDaoImpl#getStock()}.
	 */
	@Test
	public void testGetStock() {
		List<Stock> stocks = dao.getStock();
		for (Stock stock : stocks) {
			System.out.println(stock.getStoresName());
		}
	}

	/**
	 * Test method for
	 * {@link onlyfun.js.dao.impl.StockDaoImpl#getStockById(long)}.
	 */
	@Test
	public void testGetStockById() {
		Stock stock = dao.getStockById(2);
		assertEquals("Success!", "368-9720-68532", stock.getStoresId());
	}

	/**
	 * Test method for
	 * {@link onlyfun.js.dao.impl.StockDaoImpl#update(onlyfun.js.model.Stock)}.
	 */
	@Test
	public void testUpdate() {
		Stock stock = dao.getStockById(2);
		stock.setMinNum(21);
		dao.update(stock);
	}

	/**
	 * Test method for
	 * {@link onlyfun.js.dao.impl.StockDaoImpl#deleteStockById(long)}.
	 */
	@Test
	public void testDeleteStockById() {
		dao.deleteStockById(3);
	}

	/**
	 * Test method for
	 * {@link onlyfun.js.dao.impl.StockDaoImpl#deleteStock(onlyfun.js.model.Stock)}
	 * .
	 */
	@Test
	public void testDeleteStock() {
		Stock stock = dao.getStockById(3);
		dao.deleteStock(stock);
	}

	/**
	 * Test method for
	 * {@link onlyfun.js.dao.impl.StockDaoImpl#addStock(onlyfun.js.model.Stock)}
	 * .
	 */
	@Test
	public void testAddStock() {
		Stock stock = new Stock();
		stock.setCurrentNum(30);
		stock.setMinNum(20);
		stock.setPrice(52);
		stock.setStoresName("电脑桌");
		dao.addStock(stock);
	}

}
