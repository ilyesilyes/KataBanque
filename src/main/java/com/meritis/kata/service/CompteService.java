package com.meritis.kata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritis.kata.DAO.CompteDAO;
import com.meritis.kata.DAO.OperationDAO;
import com.meritis.kata.model.Compte;
import com.meritis.kata.model.Operation;
import java.time.LocalDateTime;
@Service
public class CompteService {
	
	@Autowired
	private CompteDAO compteDAO; 
	
	@Autowired
	private OperationDAO operationDAO;

	public String createCompte(Compte compte) {
		String message;
		try {
			compteDAO.save(compte);
			message = "OK";
		} catch (Exception e) {
			message = e.getMessage();
		} 
		return message;
	}
	
	public String deleteCompte(String compteId) {
		String message;
		try {
			compteDAO.deleteById(Long.parseLong(compteId));
			message = "OK";
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;	
	}	
	
	public String depotCompte(String compteId, Double somme) {
		Optional<Compte> compte = compteDAO.findById(Long.parseLong(compteId));
		if (compte.isPresent()) {
			compte.get().setSolde(compte.get().getSolde() + somme);
			compteDAO.save(compte.get());
			operationDAO.save(new Operation("depot " + compteId, LocalDateTime.now(), somme, compte.get()));
			return "OK";
		}
		return "Compte not found";
	}	
	
	public String retaitCompte(String compteId, Double somme) {
		Optional<Compte> compte = compteDAO.findById(Long.parseLong(compteId));
		if (compte.isPresent()) {
			compte.get().setSolde(compte.get().getSolde() - somme);
			compteDAO.save(compte.get());
			operationDAO.save(new Operation("retrait" + " " + compteId, LocalDateTime.now(), somme, compte.get()));
			return "OK";
		}
		return "Compte not found";	
	}
	
	public List<Operation> histoireCompte(String compteId) {
		Long a = Long.parseLong(compteId);
		return operationDAO.findByCompteId(Long.parseLong(compteId));
	}
	
	public List<Operation> histoireToutCompte() {
		List<Operation> result = new ArrayList<Operation>();
		operationDAO.findAll().forEach(elem -> result.add(elem));
		return result;
	}
	
	public List<Compte> getAllCompte() {
		List<Compte> result = new ArrayList<Compte>();
		compteDAO.findAll().forEach(elem -> result.add(elem));
		return result;
	}

}
