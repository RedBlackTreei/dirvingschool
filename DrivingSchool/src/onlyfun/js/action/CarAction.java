package onlyfun.js.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import onlyfun.js.model.Car;
import onlyfun.js.service.CarService;
import onlyfun.js.uitl.Json;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 项目名称：DrivingSchool <br/>
 * 类名称：CarAction <br/>
 * 类描述：车辆控制类 <br/>
 * 创建人：js <br/>
 * 创建时间：2012-12-5 上午10:25:07 <br/>
 * 修改人：js <br/>
 * 修改时间：2012-12-5 上午10:25:07 <br/>
 * 修改备注： <br/>
 * 
 * @version <br/>
 */
@Controller
public class CarAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private static final long serialVersionUID = 9222513308560769468L;
	private Car car;
	private CarService carService;
	private HttpServletRequest request;
	private HttpServletResponse response;

	/**
	 * 获取车辆列表<br/>
	 * 包含使用者(教练、学生)的姓名<br/>
	 * 
	 * @throws IOException
	 *             void
	 */
	public void getCarList() throws IOException {
		String[] key = new String[] { "'id'", "'plateNum'", "'regDate'",
				"'remark'", "'type'", "'stuName'", "'coachName'", "'stuId'",
				"'coachId'" };
		try {
			List<Object[]> cars = this.carService.getCarListWithUser();
			List<String> list = Json.toJson(key, cars);
			String json = JSONArray.fromObject(list).toString();
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

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public CarService getCarService() {
		return carService;
	}

	@Resource
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

}
