package br.com.fiap.persistencia.atividade4.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="paciente", schema="consultorio")
public class Paciente implements Serializable {


	private static final long serialVersionUID = 7867919112292608562L;

	@Id
	@Column(length=11, name="CPF")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cpf;
	
	@Column(name="NOME", length=45)
	private String nome;
	
	@Column(name="DATANASC")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datanasc;
	
	@Column(name="TELEFONE", length=20)
	private String telefone;
	
	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agenda_paciente", joinColumns = @JoinColumn(name = "PACIENTE_CPF"), inverseJoinColumns = @JoinColumn(name = "AGENDA_ID"))
	private List<Agenda> agenda;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cpfPac")
	private List<Procedimento> procedimentos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cpfPac")
	private List<Matmed> materiaisMedicos;
	
	public String getCpf() {
		return cpf;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<Matmed> getMateriaisMedicos() {
		return materiaisMedicos;
	}

	public void setMateriaisMedicos(List<Matmed> materiaisMedicos) {
		this.materiaisMedicos = materiaisMedicos;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}


