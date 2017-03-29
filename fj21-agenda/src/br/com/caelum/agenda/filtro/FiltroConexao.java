package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("entrou no filtro de conexao...");
		
		try {
			//conexao de bd agora eh no Filtro
			Connection connection = new ConnectionFactory().getConnection();
			
			//pendurando a connection na requisicao
			request.setAttribute("conexao", connection);
			
			chain.doFilter(request, response);
			
			System.out.println("saiu do filtro de conexao...");
			connection.close();
		
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	
	}
	
	public void init(FilterConfig config){
		
	}

	public void destroy(){
		
	}

}
