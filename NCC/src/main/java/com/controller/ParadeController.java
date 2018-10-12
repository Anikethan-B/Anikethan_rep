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

import com.entity.Parade;
import com.serviceInterfaces.ParadeServiceInterface;

@RestController
public class ParadeController 

{

	@Autowired
	private ParadeServiceInterface paradeServiceInterface;
	
	@RequestMapping(value = "/parades", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Parade>> parades() {

		  HttpHeaders headers = new HttpHeaders();
		  List<Parade> parade = paradeServiceInterface.getParades();

		  if (parade == null) {
		   return new ResponseEntity<List<Parade>>(HttpStatus.NOT_FOUND);
		  }
		  headers.add("Number Of Records Found", String.valueOf(parade.size()));
		  return new ResponseEntity<List<Parade>>(parade, headers, HttpStatus.OK);
		 }
	
	@RequestMapping(value = "/parade/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Parade> getParade(@PathVariable("id") int parade_id) {
	  Parade parade = paradeServiceInterface.getParade(parade_id);
	  if (parade == null) {
	   return new ResponseEntity<Parade>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Parade>(parade, HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/parade/delete/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Parade> deleteParade(@PathVariable("id") int parade_id) {
	  HttpHeaders headers = new HttpHeaders();
	  Parade parade = paradeServiceInterface.getParade(parade_id);
	  if (parade == null) {   
	   return new ResponseEntity<Parade>(HttpStatus.NOT_FOUND);
	  }
	  paradeServiceInterface.deleteParade(parade_id);
	  headers.add("parade Deleted - ", String.valueOf(parade_id));
	  return new ResponseEntity<Parade>(parade, headers, HttpStatus.NO_CONTENT);
	 }
	
	@RequestMapping(value = "/parade", method = RequestMethod.POST,produces = "application/json")
	 public ResponseEntity<Parade> createParade(@RequestBody Parade parade) {
	  HttpHeaders headers = new HttpHeaders();
	  if (parade == null) {
	   return new ResponseEntity<Parade>(HttpStatus.BAD_REQUEST);
	  }
	  paradeServiceInterface.createParade(parade);
	  headers.add("parade Created  - ", String.valueOf(parade.getParade_id()));
	  return new ResponseEntity<Parade>(parade, headers, HttpStatus.CREATED);
	 }
	
	@RequestMapping(value = "/parade/update/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Parade> updateParade(@PathVariable("id") int parade_id, @RequestBody Parade parade) {
	  HttpHeaders headers = new HttpHeaders();
	  Parade isExist = paradeServiceInterface.getParade(parade_id);
	  if (isExist == null) {   
	   return new ResponseEntity<Parade>(HttpStatus.NOT_FOUND);
	  } else if (parade == null) {
	   return new ResponseEntity<Parade>(HttpStatus.BAD_REQUEST);
	  }
	  paradeServiceInterface.updateParade(parade);
	  headers.add("parade Updated  - ", String.valueOf(parade_id));
	  return new ResponseEntity<Parade>(parade, headers, HttpStatus.OK);
	 }
}
