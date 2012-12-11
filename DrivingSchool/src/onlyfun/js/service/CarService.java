package onlyfun.js.service;

import java.util.List;

import onlyfun.js.model.Car;
import onlyfun.js.model.Coach;

/**
 * 车辆管理
 * @version
 */
public interface CarService {
	/**
	 * 获取车辆列表
	 * @return List<Car>
	 */
	public List<Car> getCarList();
	
	/**
	 * 获取车辆信息，包含使用者姓名等
	 * @return
	 * List<Object[]>
	 */
	public List<Object[]> getCarListWithUser();

	/**
	 * 通过id获取车辆
	 * @param id
	 * @return Car
	 */
	public Car getCarById(long id);

	/**
	 * 添加车辆
	 * @param car
	 * void
	 */
	public void addCar(Car car);

	/**
	 * 删除车辆
	 * @param car
	 * void
	 */
	public void deleteCar(Car car);

	/**
	 * 通过id删除车辆
	 * @param id
	 * void
	 */
	public void deleteCayById(long id);

	/**
	 * 更新车辆信息
	 * @param car
	 * void
	 */
	public void update(Car car);
	
	/**
	 * 更新车辆信息，包括使用者
	 * @param car 车辆实体
	 * @param stuId 学生id
	 * @param coachId 教练id
	 * void
	 */
	public void update(Car car,long stuId,long coachId);
	
	/**
	 * 获取教练列表
	 * @return
	 * List<Coach>
	 */
	public List<Coach> getCoachList();
	
	/**
	 * 获取学生列表
	 * @return
	 * List<Student>
	 */
	public List<Object[]> getStuList();
	
	public void updateStu(Car car, String stuId);
	
	public void updateCoach(Car car, String coachId);
}
