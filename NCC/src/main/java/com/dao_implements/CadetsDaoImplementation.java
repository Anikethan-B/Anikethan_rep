package com.dao_implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import com.daoInterfaces.CadetsDaoInterface;
import com.entity.Cadets;


@Repository("cadetsDao")
public class CadetsDaoImplementation implements CadetsDaoInterface{
	private JdbcTemplate jdbcTemplate;

	
	@Autowired
	 public void setDataSource(DataSource dataSource) {
		 this.jdbcTemplate=new JdbcTemplate(dataSource);		 
	 }
	
	public List<Cadets> getCadets() {
		List<Cadets> cadets=null;
		try
		{
			cadets=jdbcTemplate.query("Select * from cadets", new BeanPropertyRowMapper<Cadets>(Cadets.class));
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		
		return cadets;
	}

	public Cadets getCadet(int cadet_id) {
		Cadets cadet=null;
		try
		{
			cadet=jdbcTemplate.queryForObject("select * from cadets where cadet_id=?", new Object[] {cadet_id},new BeanPropertyRowMapper<Cadets>(Cadets.class));
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		return cadet;
	}

	public int deleteCadet(int cadet_id) {
		int count=0;
		try
		{
			count=jdbcTemplate.update("delete * from cadets where cadet_id=?",new Object[] {cadet_id});
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int updateCadet(Cadets cadet) {
		int count=0;
		try
		{
			count=jdbcTemplate.update("update cadets set cadet_name=?, where cadet_id=?",new Object[] {cadet.getCadet_name(),cadet.getCadet_id()});
		}catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int createCadet(Cadets cadet) {
         int count=0;
         try
         {
        	 count=jdbcTemplate.update("insert into cadets(cadet_id,cadet_name,certificate_type,college_id,cadets_type_id) values(?,?,?,?,?)"
        			 ,new Object[] {cadet.getCadet_id(),cadet.getCadet_name(),cadet.getCertificate_type(),cadet.getCollege_id(),cadet.getCadets_type_id()});
         }
         catch(DataAccessException e)
         {
        	 e.printStackTrace();
         }

		return count;
	}

	public List<Cadets> getCadetsWithCollegeId(int college_id) {
		List<Cadets> cadet=null;
		try
		{
			cadet=jdbcTemplate.query("select * from Cadets where college_id=?", new Object[] {college_id}, new BeanPropertyRowMapper<Cadets>(Cadets.class));
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}
		return cadet;
	}

	public List<Cadets> getCadetsAttendParade() {
		
		return null;
	}

	

}
