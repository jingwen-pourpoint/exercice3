package BlogDemoFormation.filter;

import java.io.IOException;

import BlogDemoFormation.services.CategorieService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/articles"})
public class CategorieFilter extends HttpFilter {
	
	private CategorieService categorieService = CategorieService.getInstance();
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if (categorieService.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/categories?fromArticle");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
