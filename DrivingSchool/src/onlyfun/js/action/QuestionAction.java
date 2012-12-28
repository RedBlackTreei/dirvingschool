package onlyfun.js.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.*;
import net.sf.json.*;
import onlyfun.js.model.*;
import onlyfun.js.service.QuestionService;
import onlyfun.js.uitl.Json;
import org.apache.struts2.interceptor.*;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class QuestionAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = -199048885603455369L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private QuestionService service;
	private Question question;
	private QuestionItem item;

	public void getQuestionList() throws IOException{
		try {
			List<Question> questions = service.getQuestions();
			JsonConfig config = Json.getConfig("items");
			String json = JSONArray.fromObject(questions, config).toString();
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
	 * 获取某题目的选项
	 * @throws IOException
	 */
	public void getItemList() throws IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			List<QuestionItem> items = this.service.getItems(id);
			JsonConfig config = Json.getConfig("question");
			String json = JSONArray.fromObject(items,config).toString();
			System.out.println(json);
			this.response.setContentType("text/html; charset=UTF-8");
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

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public QuestionService getService() {
		return service;
	}

	@Resource
	public void setService(QuestionService service) {
		this.service = service;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionItem getItem() {
		return item;
	}

	public void setItem(QuestionItem item) {
		this.item = item;
	}
}