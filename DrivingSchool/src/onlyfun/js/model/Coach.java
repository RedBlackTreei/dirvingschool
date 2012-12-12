package onlyfun.js.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
@DiscriminatorValue(value = "coach")
public class Coach extends Person {

	private String teachSubject;// 教授科目
	private Integer stuNum;// 学生数目
	private Boolean stuFull = false;// 是否招满
	
	public String getTeachSubject() {
		return teachSubject;
	}

	public void setTeachSubject(String teachSubject) {
		this.teachSubject = teachSubject;
	}

	public Integer getStuNum() {
		return stuNum;
	}

	public void setStuNum(Integer stuNum) {
		this.stuNum = stuNum;
	}

	public Boolean isStuFull() {
		return stuFull;
	}

	public void setStuFull(Boolean stuFull) {
		this.stuFull = stuFull;
	}

}
