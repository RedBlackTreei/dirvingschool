package onlyfun.js.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {
	private Long id;
	private String storesName; // 存储物品名称
	private String storesId;
	private int currentNum; // 当前数量
	private int minNum; // 所需最低数量
	private double price; // 物品价格

	@Id
	@GeneratedValue
	@Column(name = "stockId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoresName() {
		return storesName;
	}

	public void setStoresName(String storesName) {
		this.storesName = storesName;
	}

	public String getStoresId() {
		return storesId;
	}

	public void setStoresId(String storesId) {
		this.storesId = storesId;
	}

	public int getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}

	public int getMinNum() {
		return minNum;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}