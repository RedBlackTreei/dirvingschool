package onlyfun.js.service;

import onlyfun.js.model.Person;

public interface UserService {
	public boolean login(String username, String password, String type);

	public void setInfo(Object obj, String type);

	public Person getInfo(String username, String type);

	public void addUser(Object obj, String type);
}
