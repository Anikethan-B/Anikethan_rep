package com.daoInterfaces;

import java.util.List;

import com.entity.Cadets;

public interface CadetsDaoInterface 
{

	public List<Cadets> getCadets();
	public Cadets getCadet(int cadet_id);
	public int deleteCadet(int cadet_id);
	public int updateCadet(Cadets cadet);
	public int createCadet(Cadets cadet);
	public List<Cadets> getCadetsWithCollegeId(int college_id);
	public List<Cadets> getCadetsAttendParade();
	
	
}
