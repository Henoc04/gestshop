package com.n2h.gestshop.bean;

import java.io.Serializable;
import java.util.List;

import com.n2h.gestshop.model.Fournisseur;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named("fournisseurBean")
@RequestScoped
public class FournisseurBean implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		 @PersistenceContext
		 private EntityManager entityManager;
		 
		 private List<Fournisseur> fournisseurs;
		  private Fournisseur fournisseur ;
		  private boolean editMode;
		  
		  @PostConstruct
		  public void init() {
			  //fournisseurs = entityManager.createQuery("SELECT e FROM Fournisseur e", Fournisseur.class) .getResultList();
			  fournisseur = new Fournisseur();
			  listeFurnisseurs();
		  }
		 
		 
		 //recuperer la tout les fournisseur
		  @Transactional
		 public List<Fournisseur> getListeFournisseurs() {
		        return fournisseurs;
		    }



		//Ajouter un fournisseur
		@Transactional
		public void addFournisseur() {
			
			entityManager.persist(fournisseur);
			fournisseur = new Fournisseur();
			listeFurnisseurs();
			
	    }
		
		/*
		 * la modification ne marche pas
		 */
		@Transactional
		 public void editFournisseur() {
			 entityManager.merge(fournisseur);
			 fournisseur = new Fournisseur();
			  editMode = false;
			listeFurnisseurs();
		    }

		
			/*
			 * la suppression ne marche pas
			 */
			@Transactional
		    public void deleteFournisseur(Fournisseur fournisseur) {
		            entityManager.remove(entityManager.merge(fournisseur));
		            listeFurnisseurs();
		       
		    }
			
		public void listeFurnisseurs() {
			fournisseurs = entityManager.createQuery("SELECT f FROM Fournisseur f", Fournisseur.class).getResultList();
		}


		public List<Fournisseur> getFournisseurs() {
			return fournisseurs;
		}


		public void setFournisseurs(List<Fournisseur> fournisseurs) {
			this.fournisseurs = fournisseurs;
		}


		public Fournisseur getFournisseur() {
			return fournisseur;
		}


		public void setFournisseur(Fournisseur fournisseur) {
			this.fournisseur = fournisseur;
		}


		public boolean isEditMode() {
			return editMode;
		}


		public void setEditMode(boolean editMode) {
			this.editMode = editMode;
		}
		
		

}

