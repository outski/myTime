package com.SA.PointageCollaborateur.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
@ManagedBean(name="affaire")
public class Affaire implements Serializable{
     
	@Id
	private String id_Affaire;
	@Column(name="nomAffaire")
	private String nom_Affaire;
	@Column(name="dateCreation")
	private Date dateCreation;
	@Column(name="Etat")
	private boolean etat=true;
	@OneToMany(mappedBy="affaires")
	private Collection<Pointage> pointages;
	
	public Affaire() {

	}


	public Affaire(String id_Affaire, String nom_Affaire, Date dateCreation, boolean etat) {
		super();
		this.id_Affaire = id_Affaire;
		this.nom_Affaire = nom_Affaire;
		this.dateCreation = dateCreation;
		this.etat = etat;
	}


	public String getId_Affaire() {
		return id_Affaire;
	}

	public void setId_Affaire(String id_Affaire) {
		this.id_Affaire = id_Affaire;
	}

	public String getNom_Affaire() {
		return nom_Affaire;
	}

	public void setNom_Affaire(String nom_Affaire) {
		this.nom_Affaire = nom_Affaire;
	}


	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	
	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Collection<Pointage> getPointages() {
		return pointages;
	}


	public void setPointages(Collection<Pointage> pointages) {
		this.pointages = pointages;
	}


	@Override
	public String toString() {
		return "Affaire [id_Affaire=" + id_Affaire + ", nom_Affaire=" + nom_Affaire + ", dateCreation=" + dateCreation
				 + ", etat=" + etat + "]";
	}	
	
}
