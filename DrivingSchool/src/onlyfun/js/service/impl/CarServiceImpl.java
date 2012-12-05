package onlyfun.js.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import onlyfun.js.dao.CarDao;
import onlyfun.js.model.Car;
import onlyfun.js.service.CarService;

/**
 * 项目名称：DrivingSchool  
 * 类名称：CarServiceImpl  
 * 类描述：  车辆管理Service类
 * 创建人：js  
 * 创建时间：2012-12-1 下午3:29:52  
 * 修改人：js  
 * 修改时间：2012-12-1 下午3:29:52  
 * 修改备注：  
 * @version  
 */
@Service
public class CarServiceImpl implements CarService {

	private CarDao carDao;

	@Override
	public List<Car> getCarList() {
		List<Car> cars = this.carDao.getCarList();
		return cars;
	}

	@Override
	public Car getCarById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCar(Car car) {
		this.carDao.addCar(car);
	}

	@Override
	public void deleteCar(Car car) {
		this.carDao.deleteCar(car);
	}

	@Override
	public void deleteCayById(long id) {
		this.carDao.deleteCarById(id);
	}

	@Override
	public void update(Car car) {
		this.carDao.update(car);
	}

	@Override
	public List<Object[]> getCarListWithUser() {
		List<Object[]> cars = this.carDao.getCarListWithUser();
		return cars;
	}
	
	public CarDao getCarDao() {
		return carDao;
	}

	@Resource
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

}
