package com.daoInterfaces;

import java.util.List;

import com.entity.Parade;

public interface ParadeDaoInterface 
{
	public List<Parade> getParades();
	public Parade getParade(int parade_id);
	public int deleteParade(int parade_id);
	public int updateParade(Parade parade);
	public int createParade(Parade parade);	
	
}
