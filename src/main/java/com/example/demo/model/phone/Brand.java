package com.example.demo.model.phone;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Brand;
	private String name;
	@OneToMany(mappedBy = "brand")
	private java.util.List<Phone> phoneList;
	public Brand() {
		super();
	}
	public Brand(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId_Brand() {
		return id_Brand;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_Brand, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return id_Brand == other.id_Brand && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Brand [id_Brand=" + id_Brand + ", name=" + name + "]";
	}	

}
