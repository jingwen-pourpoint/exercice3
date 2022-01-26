package BlogDemoFormation.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BlogDemoFormation.beans.Utilisateur;
import BlogDemoFormation.services.UtilisateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/utilisateurs")
public class UtilisateurServlet extends HttpServlet {
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	private UtilisateurService service = UtilisateurService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("utilisateurs", this.utilisateurs);
		this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/create_utilisateur.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String message;
	
			if (nom.trim().isEmpty() || prenom.trim().isEmpty() || email.trim().isEmpty()) {
				message = "Merci de remplir tout les champs";
				req.setAttribute("message", message);
			} else {
				Utilisateur utilisateur = this.service.createUtilisateur(nom, prenom, email, password);
				this.service.setUtilisateur(utilisateur);
			}
			req.setAttribute("utilisateurs", this.utilisateurs);
			this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateur/create_utilisateur.jsp").forward(req, resp);
	}

}
