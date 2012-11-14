package onlyfun.js.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.StudyItemDao;
import onlyfun.js.model.StudyItems;

@Repository
public class StudyItemDaoImpl implements StudyItemDao {

	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public List<StudyItems> getStudyItems() {
		@SuppressWarnings("unchecked")
		List<StudyItems> items = this.hibernateTemplate.find("from StudyItems");
		return items;
	}

	@Transactional
	public StudyItems getStudyItemById(long id) {
		StudyItems item = (StudyItems) this.hibernateTemplate.get(
				StudyItems.class, id);
		return item;
	}

	@Transactional
	public void update(StudyItems item) {
		this.hibernateTemplate.update(item);

	}

	@Transactional
	public void deleteStudyItemById(long itemId) {
		StudyItems item = (StudyItems) this.hibernateTemplate.get(
				StudyItems.class, itemId);
		this.hibernateTemplate.delete(item);

	}

	@Transactional
	public void deleteStudyItem(StudyItems item) {
		this.hibernateTemplate.delete(item);
	}

	@Transactional
	public void addStudyItem(StudyItems item) {
		this.hibernateTemplate.save(item);
	}

}
