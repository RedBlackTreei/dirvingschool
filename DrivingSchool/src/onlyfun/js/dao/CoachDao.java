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
	 * 通过username获取教练信息
	 */
	public Coach getCoachByUsername(String username);
	
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
	public void deleteCoachById(long coachId);
	
	/**
	 * 删除教练
	 */
	public void deleteCoach(Coach coach);
	
	/**
	 * 添加教练
	 */
	public void addCoach(Coach coach);
	
	/**
	 * 检测用户名是否存在
	 */
	public boolean isExist(String username);
	
	/**
	 * 登录
	 */
	public boolean login(String username,String password);
}
