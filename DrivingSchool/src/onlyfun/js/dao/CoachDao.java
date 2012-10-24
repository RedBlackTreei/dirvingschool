package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Coach;

/**
 * 教练管理操作
 */
public interface CoachDao {
	/**
	 * 获取教练列表
	 */
	public List<Coach> getCoach();
	
	/**
	 * 通过Id获取教练信息
	 */
	public Coach getCoachById(long coachId);
	
	/**
	 * 通过学生获取教练信息
	 */
	public Coach getCoachByStu(long stuId);
	
	/**
	 * 更新教练信息
	 */
	public void update(Coach coach);
	
	/**
	 * 删除教练
	 */
	public void deleteCoach(long coachId);
	
	/**
	 * 添加教练
	 */
	public void addCoach(Coach coach);
}
