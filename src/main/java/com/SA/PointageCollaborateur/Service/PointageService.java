package com.SA.PointageCollaborateur.Service;

import java.util.Date;
import java.util.List;

import com.SA.PointageCollaborateur.model.Affaire;
import com.SA.PointageCollaborateur.model.Collaborateur;
import com.SA.PointageCollaborateur.model.Pointage;



public interface PointageService {
	
	
/****** CRUD Collaborateur ******/
	
	public String addCollaborateur(Collaborateur c);
	public void updateCollaborateur(String matricule);
	public Collaborateur consulterCollaborateur(String matricule);
	public String desactiverCollaborateur(Collaborateur c);
	public List<Pointage> List_CollaborateurByAffaire(String id_Affaire);
	public List<Collaborateur> List_Collaborateur();

	/****** CRUD Affaire ******/
	
	public String addAffaire(Affaire a);
	public void updateAffaire(Affaire a);
	public Affaire consulterAffaire(String id_Affaire);
	public String desactiverAffaire(Affaire a);
	public List<Affaire> list_AffaireBydate(Date d1,Date d2);
	public List<Affaire> list_Affaire();
	
	/****** CRUD Pointage ******/
	
	public Pointage addPointage(Pointage p);
	public void updatePointage(Pointage p);
	public void deletPointage(Pointage p);
	public List<Pointage> listPointage();
	public Pointage consulterPointage(Long id_Pointage);
	public List<Pointage> updatePointageByDate(String semaine,String mois,int year,String matricule);
	public List<Pointage> consulterPointageByDate(String semaine,String mois,int year,String matricule);
	
	
	
	/****** Totale pointage ******/
	
	public double totalePointageByMonth(String mois,String matricule);


}
