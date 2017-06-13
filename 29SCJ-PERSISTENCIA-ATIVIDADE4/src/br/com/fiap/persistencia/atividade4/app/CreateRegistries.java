package br.com.fiap.persistencia.atividade4.app;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import br.com.fiap.persistencia.atividade4.dao.GenericDao;
import br.com.fiap.persistencia.atividade4.entity.Agenda;
import br.com.fiap.persistencia.atividade4.entity.Matmed;
import br.com.fiap.persistencia.atividade4.entity.Paciente;
import br.com.fiap.persistencia.atividade4.entity.Procedimento;

public class CreateRegistries {

	public void exec(String cpf) {
		
		Calendar calendar = new GregorianCalendar(1985, 8, 12);
		Agenda agenda = new Agenda();
		Paciente paciente = new Paciente();
		Procedimento procedimento = new Procedimento();
		Matmed materiaMedico = new Matmed();
		

		List<Paciente> listaPaciente = new ArrayList<>();
		List<Agenda> listaAgenda = new ArrayList<>();
		List<Procedimento> listaProcedimento = new ArrayList<>();
		List<Matmed> listaMaterialMedico = new ArrayList<>();

		agenda.setDescricao("Consulta Acunputurista");
		agenda.setData(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		agenda.setHora(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		listaAgenda.add(agenda);

		paciente.setCpf(cpf);
		paciente.setTelefone("3060-1200");
		paciente.setDatanasc(calendar.getTime());
		paciente.setNome("Mauro Filho");
		paciente.setAgenda(listaAgenda);
		listaPaciente.add(paciente);

		for (int i = 1; i <= 10; i++) {
			procedimento.setDescricao("Sessao de Acunpuntura" + i);
			procedimento.setPreco(new Random().nextFloat()*1000);
			procedimento.setCpfPac(paciente);
			listaProcedimento.add(procedimento);
			procedimento = new Procedimento();
		}

		for (int i = 1; i <= 10; i++) {
			
			materiaMedico.setDescricao("Agulha tamanho " + i);
			materiaMedico.setFabricante("3M");
			materiaMedico.setPreco(new Random().nextFloat()*10);
			materiaMedico.setCpfPac(paciente);
			listaMaterialMedico.add(materiaMedico);
			materiaMedico = new Matmed();
		}

		
		agenda.setPaciente(listaPaciente);
		paciente.setAgenda(listaAgenda);
		paciente.setProcedimentos(listaProcedimento);
		paciente.setMateriaisMedicos(listaMaterialMedico);

		GenericDao<Agenda> daoAgenda = new GenericDao<>(Agenda.class);
		daoAgenda.adicionar(agenda);

	}

}
