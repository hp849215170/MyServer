package m.hp.entity;

import java.io.Serializable;

public class UserDataEntity implements Serializable {

    private static final long serialVersionUID = 1l;

    private long id;//自增id
    private String carNumber;//车牌号
    private String userName;//投保人
    private String lastDate;//终保日期
    private String buyTime;//投保时间
    private String carSerialNumber;//车架号
    private String phone;//手机号
    private double syPrice;//商业险价格
    private double jqPrice;//交强险价格
    private double jcPrice;//驾乘险价格
    private double syRebate;//商业险费率
    private double jqRebate;//交强险费率
    private double jcRebate;//驾乘险费率
    private double cashBack;//返现
    private String type;//客户来源
    private String remarks;//备注

    public UserDataEntity() {

    }
    public UserDataEntity(long id, String carNumber, String userName, String lastDate, String buyTime, String carSerialNumber, String phone,
                          double syPrice, double jqPrice, double jcPrice, double syRebate,
                          double jqRebate, double jcRebate, double cashBack, String type, String remarks) {
        this.id = id;
        this.carNumber = carNumber;
        this.userName = userName;
        this.lastDate = lastDate;
        this.buyTime = buyTime;
        this.carSerialNumber = carSerialNumber;
        this.phone = phone;
        this.syPrice = syPrice;
        this.jqPrice = jqPrice;
        this.jcPrice = jcPrice;
        this.syRebate = syRebate;
        this.jqRebate = jqRebate;
        this.jcRebate = jcRebate;
        this.cashBack = cashBack;
        this.type = type;
        this.remarks = remarks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getCarSerialNumber() {
        return carSerialNumber;
    }

    public void setCarSerialNumber(String carSerialNumber) {
        this.carSerialNumber = carSerialNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSyPrice() {
        return syPrice;
    }

    public void setSyPrice(double syPrice) {
        this.syPrice = syPrice;
    }

    public double getJqPrice() {
        return jqPrice;
    }

    public void setJqPrice(double jqPrice) {
        this.jqPrice = jqPrice;
    }

    public double getJcPrice() {
        return jcPrice;
    }

    public void setJcPrice(double jcPrice) {
        this.jcPrice = jcPrice;
    }

    public double getSyRebate() {
        return syRebate;
    }

    public void setSyRebate(double syRebate) {
        this.syRebate = syRebate;
    }

    public double getJqRebate() {
        return jqRebate;
    }

    public void setJqRebate(double jqRebate) {
        this.jqRebate = jqRebate;
    }

    public double getJcRebate() {
        return jcRebate;
    }

    public void setJcRebate(double jcRebate) {
        this.jcRebate = jcRebate;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void toJson() {

    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyTime == null) ? 0 : buyTime.hashCode());
		result = prime * result + ((carNumber == null) ? 0 : carNumber.hashCode());
		result = prime * result + ((carSerialNumber == null) ? 0 : carSerialNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cashBack);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		temp = Double.doubleToLongBits(jcPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(jcRebate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(jqPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(jqRebate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lastDate == null) ? 0 : lastDate.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(syPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(syRebate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDataEntity other = (UserDataEntity) obj;
		if (buyTime == null) {
			if (other.buyTime != null)
				return false;
		} else if (!buyTime.equals(other.buyTime))
			return false;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		if (carSerialNumber == null) {
			if (other.carSerialNumber != null)
				return false;
		} else if (!carSerialNumber.equals(other.carSerialNumber))
			return false;
		if (Double.doubleToLongBits(cashBack) != Double.doubleToLongBits(other.cashBack))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(jcPrice) != Double.doubleToLongBits(other.jcPrice))
			return false;
		if (Double.doubleToLongBits(jcRebate) != Double.doubleToLongBits(other.jcRebate))
			return false;
		if (Double.doubleToLongBits(jqPrice) != Double.doubleToLongBits(other.jqPrice))
			return false;
		if (Double.doubleToLongBits(jqRebate) != Double.doubleToLongBits(other.jqRebate))
			return false;
		if (lastDate == null) {
			if (other.lastDate != null)
				return false;
		} else if (!lastDate.equals(other.lastDate))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (Double.doubleToLongBits(syPrice) != Double.doubleToLongBits(other.syPrice))
			return false;
		if (Double.doubleToLongBits(syRebate) != Double.doubleToLongBits(other.syRebate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
    
    
}
