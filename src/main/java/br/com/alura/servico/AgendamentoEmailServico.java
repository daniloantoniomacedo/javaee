package br.com.alura.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

//@Stateless indica uma instancia para cada requisicao do cliente. 
@Stateless
public class AgendamentoEmailServico {
	
	@Inject
	private AgendamentoEmailDAO agendamentoEmailDAO;
	
	public AgendamentoEmailServico() {
	}

	public List<AgendamentoEmail> listarEmails(){
		return agendamentoEmailDAO.listar();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		agendamentoEmailDAO.inserir(agendamentoEmail);
	}


}