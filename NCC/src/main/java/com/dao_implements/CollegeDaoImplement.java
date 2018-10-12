package com.dao_implements;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daoInterfaces.CollegeDaoInterface;
import com.entity.College;

@Repository("collegeDao")
public class CollegeDaoImplement implements CollegeDaoInterface{

	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	 public void setDataSource(DataSource dataSource) {
		 this.jdbcTemplate=new JdbcTemplate(dataSource);		 
	 }
	public List<College> getColleges() {
		List<College> college=null;
		
		try
		{
			college=jdbcTemplate.query("Select * from college", new BeanPropertyRowMapper<College>(College.class));
		}
		catch (DataAccessException e) {
			   e.printStackTrace();
			  }
		return college;
	}

	public College getCollege(int college_id) {
		College college=null;
		
		try
		{
			college=jdbcTemplate.queryForObject("select * from college where college_id=?",
					new Object[] {college_id},new BeanPropertyRowMapper<College>(College.class));
		}
		catch(DataAccessException e)		
		{
			e.printStackTrace();
		}
		return college;
	}

	public int deleteCollege(int college_id) {
		int count=0;
		try
		{
			count=jdbcTemplate.update("delete from college where college_id=?",new Object[] {college_id});
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int updateCollege(College college) {
        int count=0;
        try
        {
        	count=jdbcTemplate.update("Update College set college_name=? where college_id=?"
        			,new Object[] {college.getCollege_name(),college.getCollege_id()});
        }
        catch(DataAccessException e)
        {
        	e.printStackTrace();
        }
		return count;
	}

	public int createCollege(College college) {
        int count=0;
        try
        {
        	count=jdbcTemplate.update("insert into college(college_id,college_name,officer_id,unit_id)values(?,?,?,?)",
        			new Object[] {college.getCollege_id(),college.getCollege_name(),college.getOfficer_id(),college.getUnit_id()});
        }
        catch(DataAccessException e)
        {
        	e.printStackTrace();
        }
		return count;
	}
	public List<College> getCollegeWithUnitId(int unit_id) {
		List<College> colleges=null;
		try
		{
			colleges=jdbcTemplate.query("select * from college where unit_id=?",new Object[] {unit_id},new BeanPropertyRowMapper<College>(College.class));
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		
		return colleges;
	}

}
