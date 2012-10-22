package onlyfun.js.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@DiscriminatorValue(value = "student")
public class Student extends Person {
	
	private String dateOfEntry;// 入学时间
	private Coach coach; // 教练
	private LocalOfSign localOfSign;// 报名点
	private boolean isPayfee; // 是否付费
	private double fee; // 费用
	private String schoolTime; // 上课时间
	private int finshedSub; // 完成科目

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="coachId")
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public boolean isPayfee() {
		return isPayfee;
	}

	public void setPayfee(boolean isPayfee) {
		this.isPayfee = isPayfee;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getSchoolTime() {
		return schoolTime;
	}

	public void setSchoolTime(String schoolTime) {
		this.schoolTime = schoolTime;
	}

	public int getFinshedSub() {
		return finshedSub;
	}

	public void setFinshedSub(int finshedSub) {
		this.finshedSub = finshedSub;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="localId")
	public LocalOfSign getLocalOfSign() {
		return localOfSign;
	}
	
	public void setLocalOfSign(LocalOfSign localOfSign) {
		this.localOfSign = localOfSign;
	}
}
