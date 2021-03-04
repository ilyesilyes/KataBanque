package com.meritis.kata.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Compte {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double solde = 0D;
	private String nom;
	private String prenon;

	public Compte(Double solde, String nom, String prenon) {
		super();
		this.solde = solde;
		this.nom = nom;
		this.prenon = prenon;
	}
	
	public Compte(Long id) {
		id = id;
	}
	
	public Compte() {
	}

	public Double getSolde() {
		return solde;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenon() {
		return prenon;
	}

	public void setPrenon(String prenon) {
		this.prenon = prenon;
	}
	
	
	
	
}
