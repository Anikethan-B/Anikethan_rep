package com.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao_implements.ParadeDaoImplement;
import com.entity.Parade;
import com.serviceInterfaces.ParadeServiceInterface;

@Service
public class ParadeServiceImplement implements ParadeServiceInterface
{

	@Autowired
	private ParadeDaoImplement paradeDaoImplement;
	
	
	public List<Parade> getParades() {
		List<Parade> parade=paradeDaoImplement.getParades();
		return parade;
	}

	public Parade getParade(int parade_id) {
		return paradeDaoImplement.getParade(parade_id);

	}

	public int deleteParade(int parade_id) {
		return paradeDaoImplement.deleteParade(parade_id);

	}

	public int updateParade(Parade parade) {
		return paradeDaoImplement.updateParade(parade);

	}

	public int createParade(Parade parade) {
		return paradeDaoImplement.createParade(parade);

	}

}
