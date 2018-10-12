package com.serviceInterfaces;

import java.util.List;

import com.entity.College;

public interface CollegeServiceInterface 
{
     public List<College> getColleges();
     public College getCollege(int college_id);
     public int deleteCollege(int college_id);
     public int updateCollege(College college);
     public int createCollege(College college);
 	public List<College> getCollegeWithUnitId(int unit_id);

}
