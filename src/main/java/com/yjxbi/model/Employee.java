package com.yjxbi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description：用户
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3677863505650472587L;
	
	private String name;
	
	private String developer;
	
	private String zhiwu;
	
	private String sex;
	
	private String joinTime;
	
	private String contract;
	
	private String school;
	
	private String major;
	
	private String levelTime;
	
	private String education;
	
	private String code;
	
	private String birthday;
	
	private String registered;
	
	private String registeredType;
	
	private String nation;
	
	private String address;
	
	private String telphone;
	
	private String phone;
	
	private String marriage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getLevelTime() {
		return levelTime;
	}

	public void setLevelTime(String levelTime) {
		this.levelTime = levelTime;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getRegisteredType() {
		return registeredType;
	}

	public void setRegisteredType(String registeredType) {
		this.registeredType = registeredType;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	
	
}