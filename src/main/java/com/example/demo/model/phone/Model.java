package com.example.demo.model.phone;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToMany(mappedBy = "model")
	private List<Phone> modelList;
	public Model() {
		super();
	}
	public Model(String name) {
		super();
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Phone> getModelList() {
		return modelList;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, modelList, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		return id == other.id && Objects.equals(modelList, other.modelList) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", modelList=" + modelList + "]";
	}	

}
