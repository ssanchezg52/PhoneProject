package com.example.demo.model.history;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.model.phone.Phone;

@Entity
public class HistoricalPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_historicalPrice;
	@ManyToOne()
	private Phone phone;
	private Float price;
	private Date day;
	public HistoricalPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoricalPrice(Phone phone_id, Float price, Date days) {
		super();
		this.phone = phone_id;
		this.price = price;
		this.day = days;
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Phone getPhone_id() {
		return phone;
	}
	public void setPhone_id(Phone phone_id) {
		this.phone = phone_id;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	@Override
	public int hashCode() {
		return Objects.hash(day, id_historicalPrice, phone, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricalPrice other = (HistoricalPrice) obj;
		return Objects.equals(day, other.day) && Objects.equals(id_historicalPrice, other.id_historicalPrice)
				&& Objects.equals(phone, other.phone) && Objects.equals(price, other.price);
	}
	@Override
	public String toString() {
		return "PriceHistory [id=" + id_historicalPrice + ", phone_id=" + phone + ", price=" + price + ", days=" + day + "]";
	}
	
}
