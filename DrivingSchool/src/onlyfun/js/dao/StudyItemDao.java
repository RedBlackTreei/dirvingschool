package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.StudyItems;

/**
 * 学习项目管理
 */
public interface StudyItemDao {
	/**
	 * 获取所有学习项目
	 */
	public List<StudyItems> getStudyItems();

	/**
	 * 通过id获取学习项目
	 */
	public StudyItems getStudyItemById(long id);

	/**
	 * 更新学习项目
	 */
	public void update(StudyItems item);

	/**
	 * 删除学习项目
	 */
	public void deleteStudyItemById(long itemId);

	/**
	 * 删除学习项目
	 */
	public void deleteStudyItem(StudyItems item);

	/**
	 * 添加学习项目
	 */
	public void addStudyItem(StudyItems item);
}
