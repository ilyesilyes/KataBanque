package com.meritis.kata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meritis.kata.model.Compte;
import com.meritis.kata.model.Operation;
import com.meritis.kata.service.CompteService;

@RestController
@RequestMapping("kata")
public class CompteBanquaireControler {

	@Autowired
	private CompteService compteService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/createCompte")
	public String createCompte(@RequestBody Compte compte) {
		return compteService.createCompte(compte);
	}	
	
	@RequestMapping("/deleteCompte/{compteId}")
	public String deleteCompte(@PathVariable String compteId) {
		return compteService.deleteCompte(compteId);
	}
	
	@RequestMapping("/obtenirToutCompte")
	public List<Compte> obtenirToutCompte() {
		return compteService.getAllCompte();
	}	
	
	@RequestMapping("/depotCompte/{compteId}/{somme}")
	public String depotCompte(@PathVariable String compteId, @PathVariable Double somme) {
		return compteService.depotCompte(compteId, somme);
	}	
	
	@RequestMapping("/retaitCompte/{compteId}/{somme}")
	public String retaitCompte(@PathVariable String compteId, @PathVariable Double somme) {
		return compteService.retaitCompte(compteId, somme);
	}
	
	@RequestMapping("/histoireCompte/{compteId}")
	public List<Operation> histoireCompte(@PathVariable String compteId) {
		return compteService.histoireCompte(compteId);
	}
	
	@RequestMapping("/histoireToutCompte")
	public List<Operation> histoireToutCompte() {
		return compteService.histoireToutCompte();
	}
	
}
