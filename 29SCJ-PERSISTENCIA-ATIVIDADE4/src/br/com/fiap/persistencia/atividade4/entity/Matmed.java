package br.com.fiap.persistencia.atividade4.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="matmed", schema="consultorio")
public class Matmed implements Serializable {

	private static final long serialVersionUID = 2599598140350962640L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DESCRICAO", length=45)
	private String descricao;
	
	@Column(name="PRECO")
	private double preco;
	
	@Column(name="FABRICANTE", length=45)
	private String fabricante;
	
	@ManyToOne
    @JoinColumn(name = "CPFPAC")
	private Paciente cpfPac;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Paciente getCpfPac() {
		return cpfPac;
	}

	public void setCpfPac(Paciente cpfPac) {
		this.cpfPac = cpfPac;
	}
	

}
