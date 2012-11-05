package onlyfun.js.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.CoachDao;
import onlyfun.js.model.Coach;

/**
 * 教练管理操作
 */
@Repository
public class CoachDaoImpl implements CoachDao {
	
	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * 获取教练列表
	 */
	@Transactional
	public List<Coach> getCoach() {
		@SuppressWarnings("unchecked")
		List<Coach> coach = this.hibernateTemplate.find("from Coach");
		return coach;
	}

	/**
	 * 通过Id获取教练信息
	 */
	@Transactional
	public Coach getCoachById(long coachId) {
		Coach coach = (Coach)this.hibernateTemplate.get(Coach.class, coachId);
		return coach;
	}

	/**
	 * 通过学生获取教练信息
	 */
	@Transactional
	public Coach getCoachByStu(long stuId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 更新教练信息
	 */
	@Transactional
	public void update(Coach coach) {
		this.hibernateTemplate.update(coach);
		
		
	}

	/**
	 * 添加教练
	 */
	@Transactional
	public void addCoach(Coach coach) {
		this.hibernateTemplate.save(coach);
		
	}

	/**
	 * 删除教练
	 */
	@Transactional
	public void deleteCoachById(long coachId) {
		Coach coach = (Coach)this.hibernateTemplate.get(Coach.class, coachId);
		this.hibernateTemplate.delete(coach);
		
	}

	/**
	 * 删除教练
	 */
	@Transactional
	public void deleteCoach(Coach coach) {
		this.hibernateTemplate.delete(coach);
		
	}

	@Transactional
	public Coach getCoachByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<Coach> coach = this.hibernateTemplate.find("from Coach c where c.username='"+username+"'");
		return (coach.size()==0||coach==null)?null:coach.get(0);
	}
}
