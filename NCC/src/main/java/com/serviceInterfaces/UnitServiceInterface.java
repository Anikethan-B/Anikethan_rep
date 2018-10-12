package com.serviceInterfaces;

import java.util.List;

import com.entity.Unit;

public interface UnitServiceInterface 
{
 public List<Unit> getUnits();
 public Unit getUnit(int unit_Id);
 public int deleteUnit(int unit);
 public int updateUnit(Unit unit);
 public int createUnit(Unit unit);
}
