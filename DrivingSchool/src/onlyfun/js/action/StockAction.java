package onlyfun.js.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import onlyfun.js.model.Stock;
import onlyfun.js.service.StockService;

import com.opensymphony.xwork2.ActionSupport;

/**
 *库存管理控制类
 */
@Controller
public class StockAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private static final long serialVersionUID = -8496355753671067317L;
	private Stock stock;
	private StockService stockService;
	private HttpServletRequest request;
	private HttpServletResponse response;

	/**
	 * 获取库存列表 void
	 * 
	 * @throws IOException
	 */
	public void getStockList() throws IOException {
		try {
			System.out.println("begin");
			List<Stock> stocks = this.stockService.getStockList();
			for (Stock stock : stocks) {
				System.out.println(stock.getStoresName());
			}
			String json = JSONArray.fromObject(stocks).toString();
			this.response.setContentType("text/html; charset=UTF-8");
			System.out.println(json);
			this.response.getWriter().println(json);
			this.response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'获取信息失败'}");
		}
	}

	/**
	 * 编辑库存物品
	 * 
	 * @throws IOException
	 *             void
	 */
	public void editStock() throws IOException {
		try {
			this.stockService.updateStock(stock);
			this.response.getWriter().println("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'修改成功'}");
		} catch (Exception e) {
			e.printStackTrace();
			this.response.getWriter().println("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'修改失败'}");
		}
	}

	/**
	 * 删除物品
	 * void
	 * @throws IOException 
	 */
	public void deleteStock() throws IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			this.stockService.deleteStockById(id);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'删除成功'}");
		} catch (Exception e) {
			e.printStackTrace();
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'删除失败'}");
		}
	}
	
	/**
	 * 添加库存物品
	 * @throws IOException
	 * void
	 */
	public void addStock() throws IOException {
		try {
			this.stockService.addStock(stock);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'添加成功'}");
		} catch (Exception e) {
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'添加失败'}");
		}
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public StockService getStockService() {
		return stockService;
	}

	@Resource
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
