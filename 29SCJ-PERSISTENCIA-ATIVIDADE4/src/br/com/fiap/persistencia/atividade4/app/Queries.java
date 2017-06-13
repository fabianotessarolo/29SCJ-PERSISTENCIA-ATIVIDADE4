package br.com.fiap.persistencia.atividade4.app;

import java.util.List;
import java.util.ListIterator;

import br.com.fiap.persistencia.atividade4.dao.JpaUtil;
import br.com.fiap.persistencia.atividade4.entity.Matmed;
import br.com.fiap.persistencia.atividade4.entity.Paciente;
import br.com.fiap.persistencia.atividade4.entity.Procedimento;

public class Queries {

	public void exec(String cpfExemplo) {
		searchPatients();
		searchProcedures(cpfExemplo);
		searchMaterials(cpfExemplo);
		searchAllItems(cpfExemplo);
	}

	public void searchPatients() {

		List<Paciente> query = JpaUtil.getEntityManager().createQuery("SELECT c FROM Paciente c", Paciente.class)
				.getResultList();
		System.out.println("Lista de Pacientes");
		System.out.println("CPF \t\t | \tNome \r");
		for (Paciente paciente : query) {
			System.out.println(paciente.getCpf() + "\t | \t" + paciente.getNome() + "\r");
		}
	}

	public void searchProcedures(String cpfExemplo) {

		List<Procedimento> query = JpaUtil.getEntityManager()
				.createQuery("SELECT c FROM Procedimento c WHERE c.cpfPac.cpf = :cpf", Procedimento.class)
				.setParameter("cpf", cpfExemplo).getResultList();
		System.out.println("Lista de Procedimento do Paciente CPF:" + cpfExemplo);
		System.out.println("Descrição \t\t | \tPreço \r");
		for (Procedimento procedimento : query) {
			System.out.println(procedimento.getDescricao() + "\t | \t" + procedimento.getPreco() + "\r");
		}
	}

	public void searchMaterials(String cpfExemplo) {

		List<Matmed> query = JpaUtil.getEntityManager()
				.createQuery("SELECT c FROM Matmed c WHERE c.cpfPac.cpf = :cpf", Matmed.class)
				.setParameter("cpf", cpfExemplo).getResultList();
		System.out.println("Lista de Materiais do Paciente CPF:" + cpfExemplo);
		System.out.println("Descrição \t\t | \tPreço \r");
		for (Matmed material : query) {
			System.out.println(material.getDescricao() + "\t | \t" + material.getPreco() + "\r");
		}
	}

	public void searchAllItems(String cpfExemplo) {

		System.out.println("Lista de todos os itens do Paciente CPF:" + cpfExemplo);
		List<Paciente> query = JpaUtil.getEntityManager()
				.createQuery("SELECT c FROM Paciente c WHERE c.cpf = :cpf", Paciente.class)
				.setParameter("cpf", cpfExemplo).getResultList();
		System.out.println("Descrição \t\t | \tPreço \r");
		for (Paciente paciente : query) {

			StringBuilder data = new StringBuilder();
			System.out.println(paciente.getProcedimentos().size());
			
			data.append("Nome \t\t\t| Procedimento/Material \t\t| Valor \r");
			
			for (ListIterator<Procedimento> iterator = paciente.getProcedimentos().listIterator(); iterator
					.hasNext();) {

				Procedimento procedimento = (Procedimento) iterator.next();

				data.append(paciente.getNome()).append("\t\t| ").append(procedimento.getDescricao()).append("\t\t| ")
						.append(procedimento.getPreco()).append("\r");

			}
			
			for (ListIterator<Matmed> iterator = paciente.getMateriaisMedicos().listIterator(); iterator
					.hasNext();) {

				Matmed materialMedico = (Matmed) iterator.next();

				data.append(paciente.getNome()).append("\t\t| ").append(materialMedico.getDescricao()).append("\t\t\t| ")
						.append(materialMedico.getPreco()).append("\r");

			}

			System.out.println(data.toString());

		}

	}

}
