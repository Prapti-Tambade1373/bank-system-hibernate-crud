package com.bankmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Bank_Account")
public class Account {

	@Id
	@SequenceGenerator(sequenceName = "ac_generator",initialValue = 11111,allocationSize = 1,name="ac_seq")
	@GeneratedValue(generator = "ac_seq",strategy = GenerationType.SEQUENCE)	
	private int ac_no;
	@Column(name = "Account_Name")
	private String ac_name;
	@Column(name = "Account_Branch")
	private String ac_branch;
	@Column(name = "Aadhar_Number")
	private String addhar_num;
	@Column(name = "Balance")
	private double ac_bal;
	
	
	public int getAc_no() {
		return ac_no;
	}
	public String getAc_name() {
		return ac_name;
	}
	public String getAc_branch() {
		return ac_branch;
	}
	public String getAddhar_num() {
		return addhar_num;
	}
	public double getAc_bal() {
		return ac_bal;
	}
	public void setAc_no(int ac_no) {
		this.ac_no = ac_no;
	}
	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}
	public void setAc_branch(String ac_branch) {
		this.ac_branch = ac_branch;
	}
	public void setAddhar_num(String addhar_num) {
		this.addhar_num = addhar_num;
	}
	public void setAc_bal(double ac_bal) {
		this.ac_bal = ac_bal;
	}
	@Override
	public String toString() {
		return "Account [ac_no=" + ac_no + ", ac_name=" + ac_name + ", ac_branch=" + ac_branch + ", addhar_num="
				+ addhar_num + ", ac_bal=" + ac_bal + "]";
	}
	
	
}