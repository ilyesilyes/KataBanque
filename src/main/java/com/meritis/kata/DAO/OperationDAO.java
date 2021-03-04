package com.meritis.kata.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.meritis.kata.model.Operation;

public interface OperationDAO extends CrudRepository<Operation, Long>{
	
	public List<Operation> findByCompteId(Long compteId);
}
