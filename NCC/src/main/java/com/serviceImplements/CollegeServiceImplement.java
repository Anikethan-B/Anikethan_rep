package com.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoInterfaces.CollegeDaoInterface;
import com.entity.College;
import com.serviceInterfaces.CollegeServiceInterface;

@Service
public class CollegeServiceImplement implements CollegeServiceInterface
{

	@Autowired
	private CollegeDaoInterface collegeDaoInterface;
	public List<College> getColleges() {
		List<College> college=collegeDaoInterface.getColleges();
		return college;
	}

	public College getCollege(int college_id) {
		return collegeDaoInterface.getCollege(college_id);
	}

	public int deleteCollege(int college_id) {
		return collegeDaoInterface.deleteCollege(college_id);
		
	}

	public int updateCollege(College college) {
		return collegeDaoInterface.updateCollege(college); 
		 
	}

	public int createCollege(College college) {
		return collegeDaoInterface.createCollege(college);
	
	}

	public List<College> getCollegeWithUnitId(int unit_id) {
		List<College> colleges=collegeDaoInterface.getCollegeWithUnitId(unit_id);
		return colleges;
	}
	
	

}
