package br.com.fiap.persistencia.atividade4.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="agenda", schema="consultorio")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 8673968137247577173L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Temporal(value=TemporalType.DATE) 
	@Column(name="DATA")
	private Date data;
	
	@Temporal(value=TemporalType.TIME) 
	@Column(name="HORA")
	private Date hora;
	
	@Column(name="DESCRICAO",length=45)
	private String descricao;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agenda_paciente", joinColumns = @JoinColumn(name = "AGENDA_ID"), inverseJoinColumns = @JoinColumn(name = "PACIENTE_CPF"))
	private List<Paciente> paciente;

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
