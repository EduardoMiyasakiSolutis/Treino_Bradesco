package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Banco implements Serializable{
	
	private int id_banco;
	
	private String identificador;
	
	private String nome;
	
	private LocalDate data_nascimento;

	public Banco() {}
	
	public int getId_banco() {
		return id_banco;
	}

	public void setId_banco(int id_banco) {
		this.id_banco = id_banco;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	

}
