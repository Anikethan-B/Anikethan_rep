package com.serviceInterfaces;

import java.util.List;

import com.entity.Cadets;

public interface CadetsServiceInterface 
{

	public List<Cadets> getCadets();
	public Cadets getCadet(int cadet_id);
	public int deleteCadet(int cadet_id);
	public int updateCadet(Cadets cadet);
	public int createCadet(Cadets cadet);
	public List<Cadets> getCadetsWithCollege_id(int college_id);
}
