package onlyfun.js.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.LocalOfSignDao;
import onlyfun.js.model.LocalOfSign;

@Repository
public class LocalOfSignDaoImpl implements LocalOfSignDao {

	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public List<LocalOfSign> getLocal() {
		@SuppressWarnings("unchecked")
		List<LocalOfSign> local = this.hibernateTemplate
				.find("from LocalOfSign");
		return local;
	}

	@Transactional
	public LocalOfSign getLocalById(long localId) {
		LocalOfSign local = (LocalOfSign) this.hibernateTemplate.get(
				LocalOfSign.class, localId);
		return local;
	}

	@Transactional
	public void updateLocal(LocalOfSign local) {
		this.hibernateTemplate.update(local);

	}

	@Transactional
	public void deleteLocalById(long localId) {
		LocalOfSign local = (LocalOfSign) this.hibernateTemplate.get(
				LocalOfSign.class, localId);
		this.hibernateTemplate.delete(local);

	}

	@Transactional
	public void deleteLocal(LocalOfSign local) {
		this.hibernateTemplate.delete(local);
	}

	@Transactional
	public void addLocal(LocalOfSign local) {
		this.hibernateTemplate.save(local);
	}

}
