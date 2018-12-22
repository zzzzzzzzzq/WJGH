package cn.edu.wj.model;

public class GPayRecord {

	private Integer id;

	private Integer payNo;

	private String doctor;

	private String payType;

	private Integer payMoney;

	private String payWay;

	private Integer payTime;
	 
	private Boolean isPay;
	 
	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPayNo() {
		return payNo;
	}

	public void setPayNo(Integer payNo) {
		this.payNo = payNo;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Integer getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public Integer getPayTime() {
		return payTime;
	}

	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}

	public Boolean getIsPay() {
		return isPay;
	}

	public void setIsPay(Boolean isPay) {
		this.isPay = isPay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 
}
