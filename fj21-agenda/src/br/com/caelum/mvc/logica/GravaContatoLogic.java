package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class GravaContatoLogic implements Logica {

		public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

			long id = Long.parseLong(req.getParameter("id"));
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String endereco = req.getParameter("endereco");
			
			String dataEmTexto = req.getParameter("dataNascimento");
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
			
			ContatoDao dao = new ContatoDao();

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
