package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class GravaContatoLogic implements Logica {

		public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

			long id = Long.parseLong(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			
			String dataEmTexto = request.getParameter("dataNascimento");
			Calendar dataNascimento = null;
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
			} catch (java.text.ParseException e) {
				System.out.println("Erro de conversao da Data");
				return "mvc?logica=ListaContatosLogic";
			}
		    			
			Contato contato = new Contato();
			contato.setId(id);
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);
			
			Connection connection = (Connection) request.getAttribute("conexao");
			ContatoDao dao = new ContatoDao(connection);

			if (id == 0) { // Inclui
				
				dao.adiciona(contato);
				System.out.println("Incluindo contato... ");
				
			} else { // Altera	
				
				dao.atualiza(contato);
				System.out.println("Alterando contato... ");
				
			}

			return "mvc?logica=ListaContatosLogic";
			
		}
}
