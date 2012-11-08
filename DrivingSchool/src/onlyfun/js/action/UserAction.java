package onlyfun.js.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import onlyfun.js.model.Coach;
import onlyfun.js.model.Person;
import onlyfun.js.model.Student;
import onlyfun.js.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class UserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7421235784415900754L;
	
	private UserService userService;
	private Person person;
	private Coach coach;
	private Student student;
	private Map<String,Object> session;
	
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
