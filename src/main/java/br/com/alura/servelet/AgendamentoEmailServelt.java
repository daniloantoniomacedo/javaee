package br.com.alura.servelet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

@WebServlet("emails")
public class AgendamentoEmailServelt extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AgendamentoEmailServico servico;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		servico.listarEmails().forEach(email -> pw.print(email.getEmail() + "\n"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		String[] email = reader.readLine().split(",");
		
		AgendamentoEmail agendamentoEmail = new AgendamentoEmail();
		
		agendamentoEmail.setEmail(email[0]);
		agendamentoEmail.setAssunto(email[1]);
		agendamentoEmail.setMensagem(email[2]);
		
		servico.inserir(agendamentoEmail);
	}
	
}
