package model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Banco{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
