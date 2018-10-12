package com.daoInterfaces;

import java.util.List;

import com.entity.*;

public interface UnitDaoInterface 
{
	 public List<Unit> getUnits();
	 public Unit getUnit(int unit_Id);
	 public int deleteUnit(int unit_Id); 
	 public int updateUnit(Unit unit);
	 public int createUnit(Unit unit);
}
