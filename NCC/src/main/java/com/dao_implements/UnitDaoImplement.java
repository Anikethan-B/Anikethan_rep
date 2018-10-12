package com.dao_implements;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.daoInterfaces.UnitDaoInterface;
import com.entity.Unit;

@Repository("unitDao")
public class UnitDaoImplement implements UnitDaoInterface{
	
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }

	public List<Unit> getUnits() {
		List<Unit> unit=null;
		
		try {
			   unit = jdbcTemplate.query("SELECT * FROM unit",new BeanPropertyRowMapper<Unit>(Unit.class));   
			  } catch (DataAccessException e) {
			   e.printStackTrace();
			  }
			  return unit;
	}

	public Unit getUnit(int unit_Id) {
		Unit unit = null;
		  try {
		   unit = jdbcTemplate.queryForObject("SELECT * FROM unit WHERE unit_id = ?",
		     new Object[] { unit_Id }, new BeanPropertyRowMapper<Unit>(Unit.class));
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }
		  return unit;
	}

	public int deleteUnit(int unit_Id) {
		int count=0;
		try
		{
		count= jdbcTemplate.update("DELETE from unit WHERE unit_id = ?", new Object[] { unit_Id });
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		  return count;
	}

	public int updateUnit(Unit unit) {
		int count=0;
		try
		{
		count = jdbcTemplate.update(
			    "UPDATE unit set unit_name = ? where unit_id = ?", new Object[] {
			      unit.getUnit_name(), unit.getUnit_id() });
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
			  return count;
	}

	public int createUnit(Unit unit) {
		int count =0;
		try
		{
			
		count= jdbcTemplate.update(
			    "INSERT INTO unit(unit_id,unit_name)VALUES(?,?)", new Object[] {
			      unit.getUnit_id(), unit.getUnit_name()});
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
			  return count;
	}

}
