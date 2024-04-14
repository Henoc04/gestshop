package com.n2h.gestshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String name;
		private String adresse;
		private String contact;
		
		public Long getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}

		@Override
		public String toString() {
			return "Fournisseur [id=" + id + ", name=" + name + ", adresse=" + adresse + ", contact=" + contact + "]";
		}
}
