package onlyfun.js.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import onlyfun.js.dao.CoachDao;
import onlyfun.js.dao.PersonDao;
import onlyfun.js.dao.StudentDao;
import onlyfun.js.model.Coach;
import onlyfun.js.model.Person;
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

	public boolean login(String username, String password,String type) {
		if(type=="student")
			return stuDao.login(username, password);
		else if(type=="coach")
			return coachDao.login(username, password);
		else
			return personDao.login(username, password);
	}

	public void setInfo(Object obj,String type) {
		if(type=="student")
			stuDao.update((Student)obj);
		else if(type=="coach")
			coachDao.update((Coach)obj);
		else
			personDao.update((Person)obj);
	}

	public Person getInfo(String username,String type) {
		if(type=="student")
			return stuDao.getStuByUsername(username);
		else if(type=="coach")
			return coachDao.getCoachByUsername(username);
		else
			return personDao.getPersonByUsername(username);
	}

	@Override
	public void addUser(Object obj, String type) {
		if(type=="student")
			stuDao.addStudent((Student)obj);
		else if(type=="coach")
			coachDao.addCoach((Coach)obj);
		else
			personDao.addPerson((Person)obj);
		
	}

}
