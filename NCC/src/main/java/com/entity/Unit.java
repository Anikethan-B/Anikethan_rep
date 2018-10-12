package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Unit 
{
 private int unit_id;
 private String unit_name;
 
 @JsonCreator
 public Unit(@JsonProperty("unit_Id") int unit_Id, @JsonProperty("unit_Name") String unit_Name){
  this.unit_id = unit_Id;
  this.unit_name = unit_Name;
  
 }
 
 public Unit()
 {
	 
 }

public int getUnit_id() {
	return unit_id;
}

public void setUnit_id(int unit_id) {
	this.unit_id = unit_id;
}

public String getUnit_name() {
	return unit_name;
}

public void setUnit_name(String unit_name) {
	this.unit_name = unit_name;
}
 
@Override
public String toString() {
 StringBuilder str = new StringBuilder();
 str.append("Unit Id:- " + getUnit_id());
 str.append("Unit Name:- " + getUnit_name());
 
 return str.toString();
}
 
}
