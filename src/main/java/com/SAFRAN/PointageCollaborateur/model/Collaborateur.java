package com.SAFRAN.PointageCollaborateur.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
@ManagedBean(name="collaborateur")
public class Collaborateur implements Serializable{
	
	@Id
	private String matricule;
	@Column(name="MotDePasse")
	private String mdp;
	@Column(name="Nom")
	private String nom;
	@Column(name="Prenom")
	private String prenom;
	@Column(name="Email")
	private String email;
	@Column(name="Role")
	private String role;
	@Column(name="Statut")
	private String statut;
	@Column(name="DateCreation")
	private Date dateCreation;
	@Column(name="Etat")
	private boolean etat=true;
	@OneToMany(mappedBy="Collaborateurs")
	private Collection<Pointage> pointages;
	
	
	public Collaborateur() {

	}


	public Collaborateur(String matricule, String mdp, String nom, String prenom, String email, String role,
			String statut, Date dateCreation, boolean etat) {
		super();
		this.matricule = matricule;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.role = role;
		this.statut = statut;
		this.dateCreation = dateCreation;
		this.etat = etat;
	}




	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public boolean isEtat() {
		return etat;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	

	public Collection<Pointage> getPointages() {
		return pointages;
	}


	public void setPointages(Collection<Pointage> pointages) {
		this.pointages = pointages;
	}


	@Override
	public String toString() {
		return "Collaborateur [matricule=" + matricule + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", role=" + role + ", statut=" + statut + ", dateCreation=" + dateCreation
				+ ", etat=" + etat + "]";
	}


	

	
	
	
}
