package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Cadets 
{ 
	private int cadet_id;
	private String cadet_name;
	private String certificate_type;
	private int college_id;
	private int cadets_type_id;
	
	@JsonCreator
	public Cadets(@JsonProperty("Cadet_id")int cadet_id,@JsonProperty("Cadet_name")String cadet_name,
			@JsonProperty("Certificate_type")String certificate_type,@JsonProperty("College_id")int college_id,@JsonProperty("Cadets_type_id") int cadets_type_id){
		this.cadet_id=cadet_id;
		this.cadet_name=cadet_name;
		this.certificate_type=certificate_type;
		this.college_id=college_id;
		this.cadets_type_id=cadets_type_id;
		
	}
	public Cadets()
	{
		
	}

	public int getCadet_id() {
		return cadet_id;
	}

	public void setCadet_id(int cadet_id) {
		this.cadet_id = cadet_id;
	}

	public String getCadet_name() {
		return cadet_name;
	}

	public void setCadet_name(String cadet_name) {
		this.cadet_name = cadet_name;
	}

	public String getCertificate_type() {
		return certificate_type;
	}

	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}

	public int getCollege_id() {
		return college_id;
	}

	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}

	public int getCadets_type_id() {
		return cadets_type_id;
	}

	public void setCadets_type_id(int cadets_type_id) {
		this.cadets_type_id = cadets_type_id;
	}
	
	@Override
	public String toString() {
	 StringBuilder str = new StringBuilder();
	 str.append("cadet id"+getCadet_id());
	 str.append("cadet name"+getCadet_name());
	 str.append("certificate type"+getCertificate_type());
	 str.append("college id"+getCollege_id());
	 str.append("cadet_type_id"+getCadets_type_id());
	 
	 return str.toString();
	}

}