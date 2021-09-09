package br.com.alura.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

//@Stateless indica uma inst�ncia para cada requisi��o do cliente. 
@Stateless
public class AgendamentoEmailServico {
	
	@Inject
	private AgendamentoEmailDAO agendamentoEmailDAO;
	
	public List<AgendamentoEmail> listarEmails(){
		return agendamentoEmailDAO.listar();
	}

}