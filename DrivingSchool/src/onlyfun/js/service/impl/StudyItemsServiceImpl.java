package onlyfun.js.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import onlyfun.js.dao.StudyItemDao;
import onlyfun.js.model.StudyItems;
import onlyfun.js.service.StudyItemsService;

/**
 * 学习项目管理
 * @author js
 */
@Service
public class StudyItemsServiceImpl implements StudyItemsService {
	
	private StudyItemDao studyItemDao;

	/**
	 * 获取学习项目列表
	 * @return List<studyItems>
	 */
	public List<StudyItems> getStudyItems() {
		List<StudyItems> items = this.studyItemDao.getStudyItems();
		return items;
	}

	/**
	 * 获取学习项目
	 * @param id
	 * @return StudyItems
	 */
	public StudyItems getStudyItems(long id) {
		StudyItems item = this.studyItemDao.getStudyItemById(id);
		return item;
	}

	/**
	 * 添加学习项目
	 * @return void
	 */
	public void addStudyItems(StudyItems item) {
		this.studyItemDao.addStudyItem(item);
	}

	/**
	 * 删除学习项目
	 * @param id
	 * @return void
	 */
	public void deleteStudyItems(long id) {
		this.studyItemDao.deleteStudyItemById(id);

	}

	/**
	 * 更新学习项目
	 * @param items
	 * @return void
	 */
	public void update(StudyItems items) {
		this.studyItemDao.update(items);

	}

	/**
	 * 通过学习项目id更新
	 * @param id
	 * @return void
	 */
	public void update(long id) {
		StudyItems item = this.studyItemDao.getStudyItemById(id);
		this.studyItemDao.update(item);

	}

	public StudyItemDao getStudyItemDao() {
		return studyItemDao;
	}

	@Resource
	public void setStudyItemDao(StudyItemDao studyItemDao) {
		this.studyItemDao = studyItemDao;
	}

}
