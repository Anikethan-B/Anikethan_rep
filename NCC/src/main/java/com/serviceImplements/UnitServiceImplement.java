package com.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoInterfaces.UnitDaoInterface;
import com.entity.Unit;
import com.serviceInterfaces.UnitServiceInterface;

@Service("unitServiceInterface")

public class UnitServiceImplement implements UnitServiceInterface{

	@Autowired
	 private UnitDaoInterface unitDao;

	public List<Unit> getUnits() {
		List<Unit> unit=unitDao.getUnits();
		return unit;
	}

	public Unit getUnit(int unit_Id) {
		Unit unit=unitDao.getUnit(unit_Id);
		return unit;
	}

	public int deleteUnit(int unit) {
		// TODO Auto-generated method stub
		return unitDao.deleteUnit(unit);
	}

	public int updateUnit(Unit unit) {
		// TODO Auto-generated method stub
		return unitDao.updateUnit(unit);
	}

	public int createUnit(Unit unit) {
		// TODO Auto-generated method stub
		return unitDao.createUnit(unit);
	}
	

}
