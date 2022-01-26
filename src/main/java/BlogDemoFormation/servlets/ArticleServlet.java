package BlogDemoFormation.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BlogDemoFormation.beans.Article;
import BlogDemoFormation.beans.Utilisateur;
import BlogDemoFormation.services.ArticleService;
import BlogDemoFormation.services.CategorieService;
import BlogDemoFormation.services.UtilisateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/articles")
public class ArticleServlet extends HttpServlet {

	private UtilisateurService utilisateurService = UtilisateurService.getInstance();
	private CategorieService categorieService = CategorieService.getInstance();
	private ArticleService articleService = ArticleService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("auteurs", this.utilisateurService.getUtilisateurs());
		req.setAttribute("categories", this.categorieService.getCategories());
		req.setAttribute("articles", articleService.getArticles());
		this.getServletContext().getRequestDispatcher("/WEB-INF/article/create_article.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
		String contenu = req.getParameter("contenu");
		String auteur = req.getParameter("auteur");
		String categorie = req.getParameter("categorie");
		String message;

		if (titre.trim().isEmpty() || description.trim().isEmpty() || contenu.trim().isEmpty() || categorie.trim().isEmpty()) {
			message = "Merci de remplir tout les champs !";
			req.setAttribute("message", message);
		} else {
			Article article = articleService.createArticle(titre, description, contenu, auteur, categorie);
			articleService.addArticle(article);
		}

		req.setAttribute("auteurs", this.utilisateurService.getUtilisateurs());
		req.setAttribute("categories", this.categorieService.getCategories());
		req.setAttribute("articles", this.articleService.getArticles());
		this.getServletContext().getRequestDispatcher("/WEB-INF/article/create_article.jsp").forward(req, resp);
	}

}
