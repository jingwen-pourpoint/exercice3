package BlogDemoFormation.services;

import java.util.ArrayList;
import java.util.List;

import BlogDemoFormation.beans.Article;
import BlogDemoFormation.beans.Utilisateur;

public class ArticleService {

	private static ArticleService instance = null;
	private List<Article> articles = new ArrayList<>();	
	private UtilisateurService utilisateurService = UtilisateurService.getInstance();
	private CategorieService categorieService = CategorieService.getInstance();
	
	private ArticleService() {

	}
	
	public static ArticleService getInstance() {
		if (ArticleService.instance == null) {
			ArticleService.instance = new ArticleService();
		}
		return ArticleService.instance;
	}
	
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	public void addArticle(Article article) {
		this.articles.add(article);
	}
	
	public Article createArticle(String titre, String description, String contenu, String auteur, String categorie) {
		Article article = new Article(); 
		article.setTitre(titre);
		article.setContenu(contenu);
		article.setDescription(description);
		article.setAuteur(this.utilisateurService.getUtilisateur(auteur));
		article.setCategorie(this.categorieService.getCategorie(categorie));
		return article;
	}
}
