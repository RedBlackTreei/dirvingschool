package onlyfun.js.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.PersonDao;
import onlyfun.js.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public Person getPersonByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<Person> person = this.hibernateTemplate
				.find("from Person p where p.username='" + username + "'");
		return (person.size() == 0 || person.get(0) == null) ? null : person.get(0);
	}

	@Transactional
	public Person getPersonById(long id) {
		Person person = (Person) this.hibernateTemplate.get(Person.class, id);
		return person;
	}

	@Transactional
	public List<Person> getPerson() {
		@SuppressWarnings("unchecked")
		List<Person> person = this.hibernateTemplate.find("from Person");
		return person;
	}

	@Transactional
	public void update(Person person) {
		this.hibernateTemplate.update(person);
	}

}
