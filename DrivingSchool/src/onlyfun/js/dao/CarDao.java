package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Car;

/**
 * 车辆管理操作
 */
public interface CarDao {
	/**
	 * 通过教练查找
	 * 
	 * @param coachId
	 *            所属教练id
	 */
	public List<Car> getCarByCoach(long coachId);

	/**
	 * 通过车的id查找
	 * 
	 * @param carId
	 *            所要查询车辆id
	 */
	public Car getCarById(long carId);

	/**
	 * 通过车型查找
	 * 
	 * @param type
	 *            车型
	 */
	public List<Car> getCarByType(String type);

	/**
	 * 通过车牌号码查找
	 * 
	 * @param plateNum车牌号码
	 */
	public Car getCarByPlateNum(String plateNum);

	/**
	 * 通过学生查找
	 * 
	 * @param stuId
	 *            使用本车学生的id
	 */
	public List<Car> getByStudent(long stuId);

	/**
	 * 更新
	 * 
	 * @param car
	 *            所要更新车的实体类
	 */
	public void update(Car car);

	/**
	 * 添加
	 * 
	 * @param car
	 *            车的实例
	 */
	public void addCar(Car car);

	/**
	 * 通过id删除
	 * 
	 * @param carId
	 *            车的id
	 */
	public void deleteCarById(long carId);

	/**
	 * 删除
	 */
	public void deleteCar(Car car);
	
	/**
	 * 获取车辆列表
	 * 包含使用学生姓名
	 * 使用教练姓名
	 */
	
	public List<Object[]> getCarListWithUser();
	
	/**
	 * 获取车辆列表
	 */
	public List<Car> getCarList();
}
