package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Student;

/**
 * 学生管理操作
 */
public interface StudentDao {
	/**
	 * 获取学生列表
	 */
	public List<Student> getStudent();
	
	/**
	 * 通过username获取学生信息
	 */
	public Student getStuByUsername(String username);
	/**
	 * 通过Id获取学生信息
	 */
	public Student getStudentById(long stuId);
	
	/**
	 * 更新学生信息
	 */
	public void update(Student stu);
	
	/**
	 * 删除学生
	 */
	public void deleteStudent(Student stu);
	
	/**
	 * 删除学生
	 */
	public void deleteStudentById(long stuId);
	
	/**
	 * 添加学生
	 */
	public void addStudent(Student stu);
}
