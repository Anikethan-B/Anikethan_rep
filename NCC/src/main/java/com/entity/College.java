package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class College {
	private int college_id;
	private String college_name;
	private int unit_id;
	private int officer_id;
	
	@JsonCreator
	public College(@JsonProperty("College_id")int college_id,@JsonProperty("College_name")String college_name,
			@JsonProperty("Unit_id")int unit_id,@JsonProperty("Officer_id")int officer_id)
	{
		this.college_id=college_id;
		this.college_name=college_name;
		this.unit_id=unit_id;
		this.officer_id=officer_id;
	}
	
	public College()
	{
		
	}

	public int getCollege_id() {
		return college_id;
	}

	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public int getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}

	public int getOfficer_id() {
		return officer_id;
	}

	public void setOfficer_id(int officer_id) {
		this.officer_id = officer_id;
	}

	
	@Override
	public String toString() {
	 StringBuilder str = new StringBuilder();
	 str.append("College_id:-"+getCollege_id());
	 str.append("College Name:- " + getCollege_name());
	 str.append("Unit Id:- " + getUnit_id());
	 str.append("Officer Id"+getOfficer_id());
	 
	 
	 return str.toString();
	}
}
