package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parade {
      
	private int parade_id; 
	private int date;
	private int start_time; 
	private int end_time;
	private int college_id; 
	private int officer_id;
	
	@JsonCreator
	public Parade(@JsonProperty("Parade_id")int parade_id,@JsonProperty("Date")int date,@JsonProperty("Start_time")int start_time,
			@JsonProperty("End_time")int end_time,@JsonProperty("College_id")int college_id,@JsonProperty("Officer_id")int officer_id)
	{
		this.parade_id=parade_id;
		this.date=date;
		this.start_time=start_time;
		this.end_time=end_time;
		this.college_id=college_id;
		this.officer_id=officer_id;
		
	}
	public Parade()
	{
		
	}
	public int getParade_id() {
		return parade_id;
	}
	public void setParade_id(int parade_id) {
		this.parade_id = parade_id;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public int getEnd_time() {
		return end_time;
	}
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public int getOfficer_id() {
		return officer_id;
	}
	public void setOfficer_id(int officer_id) {
		this.officer_id = officer_id;
	}
	
	
}
