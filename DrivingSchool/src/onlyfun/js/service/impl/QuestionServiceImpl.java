package onlyfun.js.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import onlyfun.js.dao.QuestionDao;
import onlyfun.js.model.Question;
import onlyfun.js.service.QuestionService;

/**
 * @author ji
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao;

	@Override
	public List<Question> getQuestions() {
		List<Question> question = this.questionDao.getQuestions();
		return question;
	}

	@Override
	public void addQuestion(Question question) {
		this.questionDao.addQuestion(question);
	}
	
	@Override
	public void deleteQuestionById(long id) {
		this.questionDao.deleteQuestionById(id);
	}

	@Override
	public void deleteQuestioon(Question question) {
		this.questionDao.deleteQuesion(question);
	}

	@Override
	public void updateQuestion(Question question) {
		this.questionDao.update(question);
	}
	
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	@Resource
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
}
