package BlogDemoFormation.services;

import java.util.ArrayList;
import java.util.List;

import BlogDemoFormation.beans.Utilisateur;

public class UtilisateurService {

	private static UtilisateurService instance = null;
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();	
	
	private UtilisateurService() {

	}
	
	public static UtilisateurService getInstance() {
		if (UtilisateurService.instance == null) {
			UtilisateurService.instance = new UtilisateurService();
		}
		return UtilisateurService.instance;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
	}
	
	public Utilisateur getUtilisateur(String email) {
		Utilisateur response = null;
		for (Utilisateur utilisateur: this.utilisateurs) {
			if (utilisateur.getEmail().equals(email)) {
				response = utilisateur;
			}
		}
		return response;
	}
	
	public Boolean isEmpty() {
		Boolean response = false;
		if (this.utilisateurs.size() < 1) {
			response = true;
		}
		return response;
	}
	
	public Utilisateur createUtilisateur(String nom, String prenom, String email, String password) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(email);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setPassword(password);
		return utilisateur;
	}
}
