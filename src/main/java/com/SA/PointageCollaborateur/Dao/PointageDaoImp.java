package com.SA.PointageCollaborateur.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.SA.PointageCollaborateur.model.Affaire;
import com.SA.PointageCollaborateur.model.Collaborateur;
import com.SA.PointageCollaborateur.model.Pointage;

public class PointageDaoImp implements PointageDao{

	@PersistenceContext
	private EntityManager em;
	

	@Override
	public String addCollaborateur(Collaborateur c) {
				
		em.persist(c);
		return "Collaborateur?faces-redirect=true";
	}

	@Override
	public void updateCollaborateur(String matricule) {
		Collaborateur C=consulterCollaborateur(matricule);
		em.persist(C);
	}

	@Override
	public Collaborateur consulterCollaborateur(String matricule) {
		
		Collaborateur C=em.find(Collaborateur.class, matricule);
		if(C==null) throw new RuntimeException("employé introuvable");
		else if(C.isEtat()==false){throw new RuntimeException("employé désactivé");}
		return C;
	}

	@Override
	public String desactiverCollaborateur(Collaborateur c) {
		
		if(c.isEtat()==true) {
			c.setEtat(false);
			em.merge(c);
		}
		 return "ListCollaborateur?faces-redirect=true";
	}

	@Override
	public List<Pointage> List_CollaborateurByAffaire(String id_Affaire) {
		
		Query req=em.createQuery("select p from Pointage p where p.affaires.id_Affaire=:x");
		req.setParameter("x", id_Affaire);
		return req.getResultList();
	}

	@Override
	public List<Collaborateur> List_Collaborateur() {
		
		Query req=em.createQuery("select c from Collaborateur c where c.etat=true ");
		return req.getResultList();
	}

	@Override
	public String addAffaire(Affaire a) {
		
		em.persist(a);
		return "Affaire?faces-redirect=true";
	}

	@Override
	public void updateAffaire(Affaire a) {
		Affaire Af=consulterAffaire(a.getId_Affaire());
		em.merge(Af);
		
	}

	@Override
	public Affaire consulterAffaire(String id_Affaire) {
		
		Affaire a=em.find(Affaire.class, id_Affaire);
		if(a==null) {throw new RuntimeException("affaire introuvable");}
		else if(a.isEtat()==false){throw new RuntimeException("affaire désactivé");}
		return a;
	}

	@Override
	public String desactiverAffaire(Affaire a) {
		
		
		if(a.isEtat()==true) {
			a.setEtat(false);
			em.merge(a);
			
		}
		 return "ListAffaire?faces-redirect=true";
	}

	@Override
	public List<Affaire> list_AffaireBydate(Date d1, Date d2) {
		
		Query req=em.createQuery("select a from Affaire a where a.dateCreation>=x and a.dateCreation<=y");
		req.setParameter("x", d1);
		req.setParameter("y", d2);
		return req.getResultList();
		
	}

	@Override
	public List<Affaire> list_Affaire() {
		
		Query req=em.createQuery("select a from Affaire a where a.etat=true  ");
		return req.getResultList();
	}

	@Override
	public Pointage addPointage(Pointage p) {
		
		em.persist(p);
		return p;
	}

	@Override
	public List<Pointage> updatePointageByDate(String semaine, String mois,int year, String matricule) {
		
		List<Pointage> pointages=consulterPointageByDate(semaine, mois, year, matricule);
		em.persist(pointages);
		return pointages;
		
	}



	@Override
	public List<Pointage> consulterPointageByDate(String semaine, String mois,int year, String matricule) {
		
		Query req=em.createQuery("select p from Pointage p where p.semaine=:x and p.mois=:y and p.year=:w and p.Collaborateurs.matricule=:z");
		req.setParameter("x", semaine);
		req.setParameter("y", mois);
		req.setParameter("w", year);
		req.setParameter("z", matricule);
		return req.getResultList();
	}
	@Override
	public double totalePointageByMonth(String mois, String matricule) {
		Query req=em.createQuery("select (sum(p.j1)+ sum(p.j2)+ sum(p.j3)+ sum(p.j4)+ sum(p.j5) )from Pointage p where  p.mois=:y  and p.Collaborateurs.matricule=:z");
		req.setParameter("y", mois);
		req.setParameter("z", matricule);
		List lst= req.getResultList();
		double total;
		total=(Double) lst.get(0);
		return total;
		
	}

	@Override
	public void updatePointage(Pointage p) {
		
		em.merge(p);
		
	}

	@Override
	public Pointage consulterPointage(Long id_Pointage) {
		
		Pointage P=em.find(Pointage.class, id_Pointage);
		if(P==null) throw new RuntimeException("Pointage introuvable");
		return P;
		
	}

	@Override
	public void deletPointage(Pointage p) {
		Object managed = em.merge(p);
		em.remove(managed);
		
	}

	@Override
	public List<Pointage> listPointage() {
		
		Query req=em.createQuery("select p from Pointage p ");
		return req.getResultList();
	}

}
