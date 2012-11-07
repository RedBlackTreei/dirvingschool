package onlyfun.js.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import onlyfun.js.dao.CoachDao;
import onlyfun.js.dao.PersonDao;
import onlyfun.js.dao.StudentDao;
import onlyfun.js.model.Student;
import onlyfun.js.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private StudentDao stuDao;
	private CoachDao coachDao;
	private PersonDao personDao;

	public StudentDao getStuDao() {
		return stuDao;
	}

	@Resource
	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}

	public CoachDao getCoachDao() {
		return coachDao;
	}

	@Resource
	public void setCoachDao(CoachDao coachDao) {
		this.coachDao = coachDao;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	@Resource
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public boolean login(String username, String password) {
		return false;
	}

}
