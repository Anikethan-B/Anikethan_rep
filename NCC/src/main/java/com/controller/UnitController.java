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

import com.entity.Unit;
import com.serviceInterfaces.UnitServiceInterface;

@RestController
public class UnitController 
{
	@Autowired
	private UnitServiceInterface unitServiceInterface;
	
	 @RequestMapping(value = "/units", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Unit>> units() {

		  HttpHeaders headers = new HttpHeaders();
		  List<Unit> units = unitServiceInterface.getUnits();

		  if (units == null) {
		   return new ResponseEntity<List<Unit>>(HttpStatus.NOT_FOUND);
		  }
		  headers.add("Number Of Records Found", String.valueOf(units.size()));
		  return new ResponseEntity<List<Unit>>(units, headers, HttpStatus.OK);
		 }
	 
	 @RequestMapping(value = "/unit/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Unit> getUnit(@PathVariable("id") int unit_id) {
	  Unit unit = unitServiceInterface.getUnit(unit_id);
	  if (unit == null) {
	   return new ResponseEntity<Unit>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Unit>(unit, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/unit/delete/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Unit> deleteUnit(@PathVariable("id") int unit_id) {
	  HttpHeaders headers = new HttpHeaders();
	  Unit unit = unitServiceInterface.getUnit(unit_id);
	  if (unit == null) {   
	   return new ResponseEntity<Unit>(HttpStatus.NOT_FOUND);
	  }
	  unitServiceInterface.deleteUnit(unit_id);
	  headers.add("Unit Deleted - ", String.valueOf(unit_id));
	  return new ResponseEntity<Unit>(unit, headers, HttpStatus.NO_CONTENT);
	 }
	 
	 @RequestMapping(value = "/unit", method = RequestMethod.POST,produces = "application/json")
	 public ResponseEntity<Unit> createUnit(@RequestBody Unit unit) {
	  HttpHeaders headers = new HttpHeaders();
	  
	  if (unit == null) {
	   return new ResponseEntity<Unit>(HttpStatus.BAD_REQUEST);
	  }
	  unitServiceInterface.createUnit(unit);
	  headers.add("Unit Created  - ", String.valueOf(unit.getUnit_id()));
	  return new ResponseEntity<Unit>(unit, headers, HttpStatus.CREATED);
	 }
	 
	 @RequestMapping(value = "/unit/update/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Unit> updateUnit(@PathVariable("id") int unit_id, @RequestBody Unit unit) {
	  HttpHeaders headers = new HttpHeaders();
	  Unit isExist = unitServiceInterface.getUnit(unit_id);
	  if (isExist == null) {   
	   return new ResponseEntity<Unit>(HttpStatus.NOT_FOUND);
	  } else if (unit == null) {
	   return new ResponseEntity<Unit>(HttpStatus.BAD_REQUEST);
	  }
	  unitServiceInterface.updateUnit(unit);
	  headers.add("Unit Updated  - ", String.valueOf(unit_id));
	  return new ResponseEntity<Unit>(unit, headers, HttpStatus.OK);
	 }

}
