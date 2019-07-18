package br.com.calcard.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
/**
 * 
 * @author marco
 *
 */
@Entity
public class Cliente implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	private Integer idade;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	private Integer dependentes;
	
	@Transient
	private String nomeSexo;
	@Transient
	private String nomeEstadoCivil;	
	@Transient
	private String nomeEstado;	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Integer getDependentes() {
		return dependentes;
	}
	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}
	public String getNomeSexo() {
		if(sexo != null && nomeSexo == null)
			setNomeEstado(sexo.getLabel());
		return nomeSexo;
	}
	public void setNomeSexo(String nomeSexo) {
		this.nomeSexo = nomeSexo;
	}
	public String getNomeEstadoCivil() {
		if(estadoCivil != null && nomeEstadoCivil == null)
			nomeEstadoCivil = estadoCivil.getLabel();
		return nomeEstadoCivil;
	}
	public void setNomeEstadoCivil(String nomeEstadoCivil) {
		this.nomeEstadoCivil = nomeEstadoCivil;
	}
	public String getNomeEstado() {
		if(estado != null && nomeEstado == null)
			nomeEstado = estado.getLabel();
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	
}
