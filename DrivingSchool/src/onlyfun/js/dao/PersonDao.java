package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Person;

/**
 * 管理员操作
 */
public interface PersonDao {
	public Person getPersonByUsername(String username);
	public Person getPersonById(long id);
	public List<Person> getPerson();
	public void update(Person person);
}