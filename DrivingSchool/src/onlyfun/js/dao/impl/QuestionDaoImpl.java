package onlyfun.js.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.QuestionDao;
import onlyfun.js.model.Question;
import onlyfun.js.model.QuestionItem;

/**
 * 题库管理
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {

	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public List<Question> getQuestions() {
		@SuppressWarnings("unchecked")
		List<Question> question = this.hibernateTemplate.find("from Question");
		return question;
	}

	@Transactional
	public Question getQuestionById(long id) {
		Question question = (Question) this.hibernateTemplate.get(
				Question.class, id);
		return question;
	}

	@Transactional
	public void update(Question question) {
		this.hibernateTemplate.update(question);
	}

	@Transactional
	public void deleteQuestionById(long questionId) {
		Question question = (Question) this.hibernateTemplate.get(
				Question.class, questionId);
		this.hibernateTemplate.delete(question);

	}

	@Transactional
	public void deleteQuesion(Question question) {
		this.hibernateTemplate.delete(question);
	}

	@Transactional
	public void addQuestion(Question question) {
		this.hibernateTemplate.save(question);
	}

	@Override
	public List<QuestionItem> getItemsById(long id) {
		List<QuestionItem> list = new ArrayList<QuestionItem>();
		Question question = (Question)this.hibernateTemplate.get(Question.class, id);
		Set<QuestionItem> items = question.getItems();
		for (QuestionItem questionItem : items) {
			list.add(questionItem);
		}
		return list;
	}
}
