package onlyfun.js.model;

import javax.persistence.*;

@Entity
public class Car {

	private long id;
	private String plateNum;// 车牌号
	private String type;// 型号
	private String regDate; // 登记日期
	private Coach coach; // 常用教练
	private Student student;
	private String remark; // 备注

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlateNum() {
		return plateNum;
	}

	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coachId")
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stuId")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
