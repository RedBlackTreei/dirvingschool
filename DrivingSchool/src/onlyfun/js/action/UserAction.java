package onlyfun.js.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import onlyfun.js.model.Coach;
import onlyfun.js.model.Person;
import onlyfun.js.model.Student;
import onlyfun.js.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7421235784415900754L;

	private UserService userService;
	private Person person = new Person();
	private Coach coach = new Coach();
	private Student student = new Student();
	private Map<String, Object> session;
	private List<String> type;

	public String login() {
		String username = person.getUsername();
		String password = person.getPassword();
		String userRole = "";
		if (type.get(0).equals("学员")) {
			userRole = "student";
		} else if (type.get(0).equals("教练")){
			userRole = "coach";
		} else if(type.get(0).equals("管理员")) {
			userRole = "person";
		}
		String r = type.get(0);
		System.out.println(r);
		boolean result = userService.login(username, password, userRole);
		System.out.println("result -- >" + result + "  username -- >" + person.getUsername() + "  password -- >" + password + "  type -->" +userRole);
		if (result) {
			session.put("user", userService.getInfo(username, userRole));
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
