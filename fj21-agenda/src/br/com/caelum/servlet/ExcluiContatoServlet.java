package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/excluiContato")
public class ExcluiContatoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// busca o writer
		PrintWriter out = response.getWriter();

		// buscando os parametros no request
		String id = request.getParameter("id");
				
		// monta um objeto contato e converte id para long
		Contato contato = new Contato();
		contato.setId(Long.parseLong(id));

		// exclui o contato
		ContatoDao dao = new ContatoDao();
		dao.exclui(contato);
		
		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getId() + " excluido com sucesso");
		out.println("</body>");
		out.println("</html>");

	}

}
