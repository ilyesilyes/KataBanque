package com.meritis.kata.DAO;

import org.springframework.data.repository.CrudRepository;
import com.meritis.kata.model.Compte;

public interface CompteDAO extends CrudRepository<Compte, Long> {
	 

}
