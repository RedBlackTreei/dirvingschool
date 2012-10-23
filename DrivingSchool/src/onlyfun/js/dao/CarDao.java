package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Car;

/*
 * 车辆管理操作
 */
public interface CarDao {
	/*
	 * 通过教练查找
	 */
	public List<Car> getCarByCoach(long coachId);
	
	/*
	 * 通过车的id查找
	 */
	public Car getCarById(long carId);
	
	/*
	 * 通过车型查找
	 */
	public List<Car> getCarByType(String type);
	
	/*
	 * 通过车牌号码查找
	 */
	public Car getCarByPlateNum(String plateNum);
	
	/*
	 * 通过学生查找
	 */
	public List<Car> getByStudent(long stuId);
	
	/*
	 * 更新
	 */
	public void update(long carId);
	
	/*
	 * 添加
	 */
	public void addCar(Car car);
	
	/*
	 * 删除
	 */
	public void deleteCar(long carId);
}
