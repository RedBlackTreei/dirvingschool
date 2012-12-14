package onlyfun.js.service;

import java.util.List;

import onlyfun.js.model.Question;

/**
 * @author ji
 *
 */
public interface QuestionService {
	/**
	 * 获取题目列表
	 * @return List<Question>
	 */
	public List<Question> getQuestions();
	
	/**
	 * 添加题目
	 * @param question
	 */
	public void addQuestion(Question question);
	
	/**
	 * 通过id删除题目
	 * @param id
	 */
	public void deleteQuestionById(long id);
	
	/**
	 * 删除题目
	 * @param question
	 */
	public void deleteQuestioon(Question question);
	
	/**
	 * 编辑题目
	 * @param question
	 */
	public void updateQuestion(Question question);
	
}