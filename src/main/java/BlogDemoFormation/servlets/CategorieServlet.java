package BlogDemoFormation.servlets;

import java.io.IOException;

import BlogDemoFormation.beans.Article;
import BlogDemoFormation.beans.Categorie;
import BlogDemoFormation.services.CategorieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/categories")
public class CategorieServlet extends HttpServlet {
	
	private CategorieService categorieService = CategorieService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fromArticle = req.getParameter("fromArticle");
		if (fromArticle != null) {
			String message = "Vous devez d'abord créer une catégorie avant d'ajouter un article";
			req.setAttribute("message", message);
		}
		req.setAttribute("categories", categorieService.getCategories());
		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/create_categorie.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		String message; 
		
		if (titre.trim().isEmpty()) {
			message = "Merci de remplir tout les champs !";
			req.setAttribute("message", message);
		} else {
			Categorie categorie = categorieService.createCategorie(titre);
			categorieService.addCategorie(categorie);
		}

		req.setAttribute("categories", categorieService.getCategories());
		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/create_categorie.jsp").forward(req, resp);
	}

}
