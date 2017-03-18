package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/contador")
public class Contador extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Iniciando ContadorServlet");
	}
	
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo ContadorServlet");
	}
	
	private int contador = 0; //variavel de instancia
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador++; //a cada requisicao a mesma variavel eh incrementada
		
		//recebe o writer
		PrintWriter out = response.getWriter();
		
		//escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("Contador agora eh: " + contador);
		out.println("</body>");
		out.println("</html>");

		System.out.println("Contador agora eh: " + contador);

	}
}
