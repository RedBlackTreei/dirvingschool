package onlyfun.js.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import onlyfun.js.model.StudyItems;
import onlyfun.js.service.StudyItemsService;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 项目名称：DrivingSchool 
 * 类名称：StudyItemAction 
 * 类描述： 学习项目控制类 
 * 创建人：js 
 * 创建时间：2012-11-16 上午9:07:58 
 * 修改人：js 
 * 修改时间：2012-11-16 上午9:07:58 
 * 修改备注：
 * @version
 */

@Controller
public class StudyItemAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = -593969531752601016L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private StudyItemsService studyItemsService;
	private StudyItems items;

	/**
	 * 获取学习项目列表
	 * @throws IOException
	 * @return void
	 */
	public void getItemsList() throws IOException {
		try {
			List<StudyItems> studyItems = this.studyItemsService.getStudyItems();
			for (StudyItems studyItems2 : studyItems) {
				System.out.println(studyItems2.getItemName());
			}
			String json = JSONArray.fromObject(studyItems).toString();
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
	 * 删除学习项目
	 * @return void
	 * @throws IOException
	 */
	public void deleteItem() throws IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			this.studyItemsService.deleteStudyItems(id);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'删除成功'}");
		} catch (Exception e) {
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'删除失败'}");
		}
	}
	
	/**
	 * 修改学习项目
	 * @throws IOException
	 * @return void
	 */
	public void updateItem() throws IOException{
		try {
			this.studyItemsService.update(items);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'修改成功'}");
		} catch (Exception e) {
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'修改失败'}");
		}
	}
	
	/**
	 * 添加学习项目
	 * @throws IOException
	 * @return void
	 */
	public void addItem() throws IOException{
		try {
			this.studyItemsService.addStudyItems(items);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'添加成功'}");
		} catch (Exception e) {
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'添加失败'}");
		}
	}

	public StudyItemsService getStudyItemsService() {
		return studyItemsService;
	}

	@Resource
	public void setStudyItemsService(StudyItemsService studyItemsService) {
		this.studyItemsService = studyItemsService;
	}

	public StudyItems getItems() {
		return items;
	}

	public void setItems(StudyItems items) {
		this.items = items;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
