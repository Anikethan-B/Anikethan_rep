package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.College;
import com.entity.Unit;
import com.serviceInterfaces.CollegeServiceInterface;
import com.serviceInterfaces.UnitServiceInterface;

@RestController
public class CollegeController {
	@Autowired
	private CollegeServiceInterface collegeServiceInterface;
	@Autowired
	private UnitServiceInterface unitServiceInterface;
	
	@RequestMapping(value = "/colleges", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<College>> colleges() {

		  HttpHeaders headers = new HttpHeaders();
		  List<College> college = collegeServiceInterface.getColleges();

		  if (college == null) {
		   return new ResponseEntity<List<College>>(HttpStatus.NOT_FOUND);
		  }
		  headers.add("Number Of Records Found", String.valueOf(college.size()));
		  return new ResponseEntity<List<College>>(college, headers, HttpStatus.OK);
		 }
	
	@RequestMapping(value = "/college/{id}", method = RequestMethod.GET)
	 public ResponseEntity<College> getCollege(@PathVariable("id") int college_id) {
	  College college = collegeServiceInterface.getCollege(college_id);
	  if (college == null) {
	   return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<College>(college, HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/college/delete/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<College> deleteCollege(@PathVariable("id") int college_id) {
	  HttpHeaders headers = new HttpHeaders();
	  College college = collegeServiceInterface.getCollege(college_id);
	  if (college == null) {   
	   return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
	  }
	  collegeServiceInterface.deleteCollege(college_id);
	  headers.add("college Deleted - ", String.valueOf(college_id));
	  return new ResponseEntity<College>(college, headers, HttpStatus.NO_CONTENT);
	 }
	
	@RequestMapping(value = "/college", method = RequestMethod.POST,produces = "application/json")
	 public ResponseEntity<College> createCollege(@RequestBody College college) {
	  HttpHeaders headers = new HttpHeaders();
	  if (college == null) {
	   return new ResponseEntity<College>(HttpStatus.BAD_REQUEST);
	  }
	  collegeServiceInterface.createCollege(college);
	  headers.add("college Created  - ", String.valueOf(college.getCollege_id()));
	  return new ResponseEntity<College>(college, headers, HttpStatus.CREATED);
	 }
	
	@RequestMapping(value = "/college/update/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<College> updateCollege(@PathVariable("id") int college_id, @RequestBody College college) {
	  HttpHeaders headers = new HttpHeaders();
	  College isExist = collegeServiceInterface.getCollege(college_id);
	  if (isExist == null) {   
	   return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
	  } else if (college == null) {
	   return new ResponseEntity<College>(HttpStatus.BAD_REQUEST);
	  }
	  collegeServiceInterface.updateCollege(college);
	  headers.add("college Updated  - ", String.valueOf(college_id));
	  return new ResponseEntity<College>(college, headers, HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/college/unit/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<College>> getCollegeWithUnitId(@PathVariable("id") int unit_id)
	{
		HttpHeaders header= new HttpHeaders();
		Unit unit = unitServiceInterface.getUnit(unit_id);
		if(unit==null)
		{
			return new ResponseEntity<List<College>>(HttpStatus.NOT_FOUND);
		}
		else
		{
		List<College> colleges=collegeServiceInterface.getCollegeWithUnitId(unit_id);
		if(colleges==null)
		{
			return new ResponseEntity<List<College>>(HttpStatus.NOT_FOUND);

		}
		header.add("no of records found", String.valueOf(unit_id));
		return new ResponseEntity<List<College>>(colleges,header,HttpStatus.OK);
		}
	}

}
