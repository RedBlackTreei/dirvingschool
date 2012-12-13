package onlyfun.js.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import onlyfun.js.dao.CarDao;
import onlyfun.js.dao.CoachDao;
import onlyfun.js.dao.StudentDao;
import onlyfun.js.model.Car;
import onlyfun.js.model.Coach;
import onlyfun.js.model.Student;
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
	private CoachDao caochDao;
	private StudentDao stuDao;

	@Override
	public List<Car> getCarList() {
		List<Car> cars = this.carDao.getCarList();
		return cars;
	}

	@Override
	public Car getCarById(long id) {
		Car car = this.carDao.getCarById(id);
		return car;
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
	

	@Override
	public List<Object[]> getCoachList() {
		List<Object[]> list = this.caochDao.getCoaches();
		return list;
	}

	@Override
	public List<Object[]> getStuList() {
		List<Object[]> students = this.stuDao.getStudentsList();
		return students;
	}

	@Override
	public void update(Car car, String stuId, String coachId) {
		car.setCoach(getCoach(coachId));
		car.setStudent(getStu(stuId));
		this.carDao.update(car);
	}

	@Override
	public void updateUser(String carId, String stuId, String coachId) {
		Student stu = this.getStu(stuId);
		Coach coach = this.getCoach(coachId);
		Car car = this.getCar(carId);
		car.setStudent(stu);
		car.setCoach(coach);
		this.carDao.update(car);
	}
	
	private Student getStu(String stuId){
		if(!stuId.equals("")){
			long sId = Long.parseLong(stuId);
			return this.stuDao.getStudentById(sId);
		} else {
			return null;
		}
	}
	
	private Car getCar(String carId) {
		if(!carId.equals("")){
			long cId = Long.parseLong(carId);
			return this.carDao.getCarById(cId);
		} else {
			return null;
		}
	}
	
	private Coach getCoach(String coachId){
		if(!coachId.equals("")){
			long cId = Long.parseLong(coachId);
			return this.caochDao.getCoachById(cId);
		} else {
			return null;
		}
	}
	
	
	public CarDao getCarDao() {
		return carDao;
	}

	@Resource
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public CoachDao getCaochDao() {
		return caochDao;
	}

	@Resource
	public void setCaochDao(CoachDao caochDao) {
		this.caochDao = caochDao;
	}

	public StudentDao getStuDao() {
		return stuDao;
	}

	@Resource
	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}

}
