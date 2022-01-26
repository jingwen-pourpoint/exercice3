package BlogDemoFormation.services;

import java.util.ArrayList;
import java.util.List;

import BlogDemoFormation.beans.Article;
import BlogDemoFormation.beans.Categorie;

public class CategorieService {

	private static CategorieService instance = null;
	private List<Categorie> categories = new ArrayList<>();
	
	private CategorieService() {

	}
	
	public static CategorieService getInstance() {
		if (CategorieService.instance == null) {
			CategorieService.instance = new CategorieService();
		}
		return CategorieService.instance;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	public void addCategorie(Categorie categorie) {
		this.categories.add(categorie);
	}
	
	public Categorie createCategorie(String titre) {
		Categorie categorie = new Categorie(); 
		categorie.setTitre(titre);
		return categorie;
	}
	
	public Categorie getCategorie(String titre) {
		return categories.stream()
				.filter(categorie -> titre.equals(categorie.getTitre()))
				.findAny()
				.orElse(null);
	}
	
	public boolean isEmpty() {
		return categories.isEmpty();
	}
	
}
