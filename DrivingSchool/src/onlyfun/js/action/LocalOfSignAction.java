package onlyfun.js.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import onlyfun.js.model.LocalOfSign;
import onlyfun.js.service.LocalOfSignService;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 报名点管理控制类
 * 
 * @version
 */
@Controller
public class LocalOfSignAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 3910282797826049097L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private LocalOfSignService localOfSignService;
	private LocalOfSign localOfSign;

	/**
	 * 获取报名点列表
	 * 
	 * @throws IOException
	 *             void
	 */
	public void getLocalOfSignList() throws IOException {
		try {
			List<LocalOfSign> localOfSigns = localOfSignService
					.getLocalOfSignList();
			String json = JSONArray.fromObject(localOfSigns).toString();
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println(json);
			this.response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'获取信息失败'}");
		}
	}

	/**
	 * 添加报名点
	 * 
	 * @throws IOException
	 *             void
	 */
	public void addLocalOfSign() throws IOException {
		try {
			localOfSignService.addLocalOfSign(localOfSign);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'添加成功'}");
		} catch (Exception e) {
			e.printStackTrace();
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'添加失败'}");
		}
	}

	/**
	 * 删除报名点
	 * 
	 * @throws IOException
	 *             void
	 */
	public void deleteLocalOfSign() throws IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			localOfSignService.deleteLocalOfSignById(id);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'删除成功'}");
		} catch (Exception e) {
			e.printStackTrace();
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'删除失败'}");
		}
	}
	
	/**
	 * 编辑报名点
	 * @throws IOException
	 * void
	 */
	public void editLocalOfSign() throws IOException{
		try {
			localOfSignService.updateLocalOfSign(localOfSign);
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:true, msg:'编辑成功'}");
		} catch (Exception e) {
			e.printStackTrace();
			this.response.setContentType("text/html; charset=UTF-8");
			this.response.getWriter().println("{success:false, msg:'编辑失败'}");
		}
	}

	public LocalOfSignService getLocalOfSignService() {
		return localOfSignService;
	}

	@Resource
	public void setLocalOfSignService(LocalOfSignService localOfSignService) {
		this.localOfSignService = localOfSignService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public LocalOfSign getLocalOfSign() {
		return localOfSign;
	}

	public void setLocalOfSign(LocalOfSign localOfSign) {
		this.localOfSign = localOfSign;
	}

}
