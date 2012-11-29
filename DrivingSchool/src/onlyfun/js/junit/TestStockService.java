package onlyfun.js.junit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import onlyfun.js.model.Stock;
import onlyfun.js.service.StockService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStockService {

	StockService ss = null;
	ApplicationContext context = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * @throws java.lang.Exception
	 * void
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ss = (StockService)context.getBean("stockServiceImpl");
	}

	/**
	 * @throws java.lang.Exception
	 * void
	 */
	@After
	public void tearDown() throws Exception {
		context = null;
		ss = null;
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StockServiceImpl#getStockList()}.
	 */
	@Test
	public final void testGetStockList() {
		List<Stock> stocks = this.ss.getStockList();
		for (Stock stock : stocks) {
			System.out.println(stock.getStoresName());
		}
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StockServiceImpl#getStockById(long)}.
	 */
	@Test
	public final void testGetStockById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StockServiceImpl#deleteStock(onlyfun.js.model.Stock)}.
	 */
	@Test
	public final void testDeleteStock() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StockServiceImpl#deleteStockById(long)}.
	 */
	@Test
	public final void testDeleteStockById() {
		for(int i=0;i<3;i++){
			this.ss.deleteStockById(i+3);
		}
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StockServiceImpl#addStock(onlyfun.js.model.Stock)}.
	 */
	@Test
	public final void testAddStock() {
		for (int i = 0; i < 3; i++) {
			Stock stock = new Stock();
			stock.setStoresName("杯子");
			stock.setPrice(1.9);
			stock.setMinNum(30);
			stock.setCurrentNum(40);
			this.ss.addStock(stock);
		}
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.StockServiceImpl#updateStock(onlyfun.js.model.Stock)}.
	 */
	@Test
	public final void testUpdateStock() {
		fail("Not yet implemented"); // TODO
	}

}
