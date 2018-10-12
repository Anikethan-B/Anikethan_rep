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

import com.entity.Cadets;
import com.entity.College;
import com.serviceInterfaces.CadetsServiceInterface;
import com.serviceInterfaces.CollegeServiceInterface;

@RestController
public class CadetsController 
{
 
	@Autowired
	private CadetsServiceInterface cadetsServiceInterface;
	
	@Autowired
	private CollegeServiceInterface collegeServiceInterface;
	
	@RequestMapping(value = "/cadets", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Cadets>> cadets()
	 {
		HttpHeaders headers = new HttpHeaders();
		List<Cadets> cadet=cadetsServiceInterface.getCadets();
		if(cadet==null)
		{
			return new ResponseEntity<List<Cadets>>(HttpStatus.NOT_FOUND);
		}
		headers.add("No of Records found", String.valueOf(cadet.size()));
		return new ResponseEntity<List<Cadets>>(cadet,headers,HttpStatus.OK);
		
	 }
	
	@RequestMapping(value = "/cadt/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Cadets> getCadet(@PathVariable("id")int cadet_id)
	{
		Cadets cadet=cadetsServiceInterface.getCadet(cadet_id);
		if(cadet==null)
		{
			return new ResponseEntity<Cadets>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cadets>(cadet,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cadet/delete/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Cadets> deleteCadet(@PathVariable("id") int cadet_id)
	{
		Cadets cadet=cadetsServiceInterface.getCadet(cadet_id);
		HttpHeaders headers=new HttpHeaders();
		if(cadet==null)
		{
			return new ResponseEntity<Cadets>(HttpStatus.NOT_FOUND);
		}
		cadetsServiceInterface.deleteCadet(cadet_id);
		headers.add("Cadet Deleted", String.valueOf(cadet_id));
		return new ResponseEntity<Cadets>(cadet,headers,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cadet/update/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Cadets> updateCadet(@PathVariable("id") int cadet_id)
	{
		HttpHeaders headers=new HttpHeaders();
		Cadets cadet=cadetsServiceInterface.getCadet(cadet_id);
		if(cadet==null)
		{
			return new ResponseEntity<Cadets>(HttpStatus.NOT_FOUND);
		}
		cadetsServiceInterface.updateCadet(cadet);
		headers.add("cadet updated", String.valueOf(cadet_id));
		return new ResponseEntity<Cadets>(cadet,headers,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cadet/create",method=RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Cadets> createCadet(@RequestBody Cadets cadet)
	{
		HttpHeaders headers=new HttpHeaders();
		if(cadet==null)
		{
			return new ResponseEntity<Cadets>(HttpStatus.BAD_REQUEST);
		}
		cadetsServiceInterface.createCadet(cadet);
		headers.add("cadet created", String.valueOf(cadet));
		return new ResponseEntity<Cadets>(cadet,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/cadets/college/{id}", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<Cadets>> getCadetsWithCollege_id(@PathVariable("id") int college_id)
	{
		College college=collegeServiceInterface.getCollege(college_id);
		if(college==null)
		{
			return new ResponseEntity<List<Cadets>>(HttpStatus.NOT_FOUND);
		}
		List<Cadets> cadet=cadetsServiceInterface.getCadetsWithCollege_id(college_id);
		if(cadet==null)
		{
			return new ResponseEntity<List<Cadets>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cadets>>(cadet,HttpStatus.OK);
	}
	
}
