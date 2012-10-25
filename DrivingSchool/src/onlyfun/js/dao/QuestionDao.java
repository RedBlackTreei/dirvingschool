package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Question;

/**
 * 题库管理
 */
public interface QuestionDao {
	/**
	 * 获取所有题目
	 */
	public List<Question> getQuestions();
	
	/**
	 * 通过id获取题目
	 */
	public Question getQuestionById(long id);
	
	/**
	 * 更新题目
	 */
	public void update(Question question);
	
	/**
	 * 删除题目
	 */
	public void deleteQuestionById(long questionId);
	
	/**
	 * 删除题目
	 */
	public void deleteQuesion(Question question);
	
	/**
	 * 添加题目
	 */
	public void addQuestion(Question question);
}
