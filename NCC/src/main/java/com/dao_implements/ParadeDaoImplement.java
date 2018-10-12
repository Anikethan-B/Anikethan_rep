package com.dao_implements;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daoInterfaces.ParadeDaoInterface;
import com.entity.Parade;

@Repository("ParadeDao")
public class ParadeDaoImplement implements ParadeDaoInterface {
	
	private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	 public void setDataSource(DataSource dataSource)
	 {
		 this.jdbcTemplate=new JdbcTemplate(dataSource);		 
	 }

	public List<Parade> getParades() {
List<Parade> parade=null;
		
		try
		{
			parade=jdbcTemplate.query("Select * from parade", new BeanPropertyRowMapper<Parade>(Parade.class));
		}
		catch (DataAccessException e) {
			   e.printStackTrace();
			  }
		return parade;
	}

	public Parade getParade(int parade_id) {
           Parade parade=null;
		
		try
		{
			parade=jdbcTemplate.queryForObject("select * from parade where parade_id=?",
					new Object[] {parade_id},new BeanPropertyRowMapper<Parade>(Parade.class));
		}
		catch(DataAccessException e)		
		{
			e.printStackTrace();
		}
		return parade;
           
	}

	public int deleteParade(int parade_id) {
		int count=0;
		try
		{
			count=jdbcTemplate.update("delete from parade where parade_id=?",new Object[] {parade_id});
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int updateParade(Parade parade) {
		int count=0;
        try
        {
        	count=jdbcTemplate.update("Update parade set start_time=?,end_time=? where college_id=?"
        			,new Object[] {parade.getStart_time(),parade.getEnd_time()});
        }
        catch(DataAccessException e)
        {
        	e.printStackTrace();
        }
		return count;
	}

	public int createParade(Parade parade) {
		int count=0;
        try
        {
        	count=jdbcTemplate.update("insert into parade(parade_id,date,start_time,end_time,college_id,officer_id)values(?,?,?,?,?,?)",
        			new Object[] {parade.getParade_id(),parade.getDate(),parade.getStart_time(),parade.getEnd_time(),parade.getCollege_id(),parade.getOfficer_id()});
        }
        catch(DataAccessException e)
        {
        	e.printStackTrace();
        }
		return count;
	}

}
