package com.productcatalog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pincodes")
public class Pincodes {

	@Id
	int id;
	@Column(name = "pincode")
	int pincode;
	@Column(name = "procode")
	String procode;
	@Column(name = "est_del_time")
	String est_del_time;

	public Pincodes() {
		super();
	}

	public Pincodes(int id, int pincode, String procode, String est_del_time) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.procode = procode;
		this.est_del_time = est_del_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPro_code() {
		return procode;
	}

	public void setPro_code(String pro_code) {
		this.procode = pro_code;
	}

	public String getEst_del_time() {
		return est_del_time;
	}

	public void setEst_del_time(String est_del_time) {
		this.est_del_time = est_del_time;
	}

	@Override
	public String toString() {
		return "Pincodes [id=" + id + ", pincode=" + pincode + ", pro_code=" + procode + ", est_del_time="
				+ est_del_time + "]";
	}

}
