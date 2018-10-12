package com.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao_implements.CadetsDaoImplementation;
import com.entity.Cadets;
import com.serviceInterfaces.CadetsServiceInterface;

@Service
public class CadetsServiceImplement implements CadetsServiceInterface {
	
	@Autowired
	private CadetsDaoImplementation cadetsDaoImplement;
	
	public List<Cadets> getCadets() {
		
		return cadetsDaoImplement.getCadets();
	}

	public Cadets getCadet(int cadet_id) {
		
		return cadetsDaoImplement.getCadet(cadet_id);
	}

	public int deleteCadet(int cadet_id) {
		int count=cadetsDaoImplement.deleteCadet(cadet_id);
		return count;
	}

	public int updateCadet(Cadets cadet) {
		int count=cadetsDaoImplement.updateCadet(cadet);
		return count;
	}

	public int createCadet(Cadets cadet) {
		int count=cadetsDaoImplement.createCadet(cadet);
		return count;
	}

	public List<Cadets> getCadetsWithCollege_id(int college_id) {
		return cadetsDaoImplement.getCadetsWithCollegeId(college_id);
	}

}
