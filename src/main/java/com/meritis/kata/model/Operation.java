package com.meritis.kata.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;

@Entity
public class Operation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Description;
	private LocalDateTime date;
	private Double somme;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Compte compte;
	
	public Operation(String description, LocalDateTime date, Double somme, Compte compte) {
		Description = description;
		this.date = date;
		this.somme = somme;
		this.compte = compte;
	}
	
	public Operation() {
	
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getSomme() {
		return somme;
	}

	public void setSomme(Double somme) {
		this.somme = somme;
	}

}
